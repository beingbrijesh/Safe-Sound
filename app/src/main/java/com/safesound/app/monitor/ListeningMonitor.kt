package com.safesound.app.monitor

import android.bluetooth.BluetoothManager
import android.content.Context
import android.media.AudioAttributes
import android.media.AudioDeviceCallback
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.media.AudioPlaybackConfiguration
import android.os.Handler
import android.os.Looper
import com.safesound.app.data.model.DeviceState
import com.safesound.app.data.model.ListeningSessionEntity
import com.safesound.app.data.model.PlaybackInfo
import com.safesound.app.data.repo.ListeningRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class ListeningMonitor(
    private val context: Context,
    private val listeningRepository: ListeningRepository
) {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var activeSession: ActiveSession? = null
    private var currentDevice: DeviceState? = null
    private var playbackState = PlaybackInfo.inactive()
    private var samplingJob: Job? = null
    private var devicePollJob: Job? = null

    private val deviceCallback = object : AudioDeviceCallback() {
        override fun onAudioDevicesAdded(addedDevices: Array<out AudioDeviceInfo>?) {
            scope.launch { updateDeviceState() }
        }

        override fun onAudioDevicesRemoved(removedDevices: Array<out AudioDeviceInfo>?) {
            scope.launch { updateDeviceState() }
        }
    }

    private val playbackCallback = object : AudioManager.AudioPlaybackCallback() {
        override fun onPlaybackConfigChanged(configs: MutableList<AudioPlaybackConfiguration>?) {
            scope.launch { handlePlaybackConfigs(configs.orEmpty()) }
        }
    }

    fun start() {
        audioManager.registerAudioDeviceCallback(deviceCallback, Handler(Looper.getMainLooper()))
        audioManager.registerAudioPlaybackCallback(playbackCallback, Handler(Looper.getMainLooper()))

        scope.launch { updateDeviceState() }
        devicePollJob = scope.launch {
            while (isActive) {
                updateDeviceState()
                delay(DEVICE_POLL_INTERVAL_MS)
            }
        }
    }

    fun stop() {
        audioManager.unregisterAudioDeviceCallback(deviceCallback)
        audioManager.unregisterAudioPlaybackCallback(playbackCallback)
        stopSampling()
        scope.launch { listeningRepository.updatePlaybackInfo(PlaybackInfo.inactive()) }
        scope.launch { endSessionIfActive() }
        devicePollJob?.cancel()
        scope.cancel()
    }

    private suspend fun handlePlaybackConfigs(configs: List<AudioPlaybackConfiguration>) {
        val activeConfigs = configs.filter { isConfigActive(it) }
        if (activeConfigs.isEmpty()) {
            playbackState = PlaybackInfo.inactive()
            listeningRepository.updatePlaybackInfo(playbackState)
            stopSampling()
            endSessionIfActive()
            return
        }

        val primaryConfig = selectPrimaryConfig(activeConfigs)
        val contentType = resolveContentType(primaryConfig.audioAttributes)
        val appInfo = resolveAppInfoFromConfig(primaryConfig)
        val newState = PlaybackInfo(
            active = true,
            contentType = contentType,
            sourceApp = appInfo?.label,
            sourcePackage = appInfo?.packageName
        )

        val stateChanged = playbackState != newState
        playbackState = newState

        if (stateChanged && activeSession != null) {
            endSessionIfActive()
        }

        listeningRepository.updatePlaybackInfo(playbackState)
        startSampling()
    }

    private fun startSampling() {
        if (samplingJob != null) return
        samplingJob = scope.launch {
            while (isActive && playbackState.active) {
                sampleTick()
                delay(SAMPLE_INTERVAL_MS)
            }
        }
    }

    private fun stopSampling() {
        samplingJob?.cancel()
        samplingJob = null
    }

    private suspend fun sampleTick() {
        val device = detectCurrentDevice()
        if (device == null) {
            if (currentDevice != null) {
                listeningRepository.updateDeviceState(currentDevice!!.copy(isConnected = false))
                currentDevice = null
            }
            endSessionIfActive()
            return
        }

        if (currentDevice?.address != device.address || currentDevice?.isConnected == false) {
            currentDevice = device
            listeningRepository.updateDeviceState(device)
            listeningRepository.resolveSpecsForDevice(device)
        }

        val shouldStartNewSession = activeSession == null ||
            activeSession?.device?.address != device.address ||
            activeSession?.contentType != playbackState.contentType ||
            activeSession?.sourcePackage != playbackState.sourcePackage

        if (shouldStartNewSession) {
            endSessionIfActive()
            activeSession = ActiveSession(
                device = device,
                contentType = playbackState.contentType,
                sourceApp = playbackState.sourceApp,
                sourcePackage = playbackState.sourcePackage,
                startTimeMillis = System.currentTimeMillis()
            )
        }

        val volumeFraction = currentVolumeFraction()
        val now = System.currentTimeMillis()
        activeSession?.volumes?.add(volumeFraction)

        val session = activeSession
        if (session != null && now - session.startTimeMillis >= RUNNING_CHUNK_SAVE_MS) {
            persistSessionChunk(session, now, MIN_RUNNING_CHUNK_MINUTES)
            activeSession = session.copy(
                startTimeMillis = now,
                volumes = mutableListOf()
            )
        }
    }

    private suspend fun endSessionIfActive() {
        val session = activeSession ?: return
        val endTime = System.currentTimeMillis()
        persistSessionChunk(session, endTime, MIN_FINAL_CHUNK_MINUTES)
        activeSession = null
    }

    private suspend fun persistSessionChunk(
        session: ActiveSession,
        endTimeMillis: Long,
        minimumDurationMinutes: Double
    ) {
        val durationMinutes = (endTimeMillis - session.startTimeMillis).toDouble() / 60000.0
        if (durationMinutes <= minimumDurationMinutes) return
        if (session.volumes.isEmpty()) return

        val avgVolume = session.volumes.average()
        val estimatedDb = listeningRepository.estimateDbFromVolume(avgVolume, null)
        val dosePercent = listeningRepository.calculateDosePercent(estimatedDb, durationMinutes)

        listeningRepository.recordSession(
            ListeningSessionEntity(
                deviceAddress = session.device.address,
                deviceName = session.device.name,
                contentType = session.contentType,
                sourceApp = session.sourceApp,
                sourcePackage = session.sourcePackage,
                startTimeMillis = session.startTimeMillis,
                endTimeMillis = endTimeMillis,
                averageVolume = avgVolume,
                estimatedDb = estimatedDb,
                dosePercent = dosePercent
            )
        )
    }

    private suspend fun updateDeviceState() {
        val device = detectCurrentDevice()
        if (device != null) {
            if (currentDevice?.address != device.address || currentDevice?.isConnected == false) {
                currentDevice = device
                listeningRepository.updateDeviceState(device)
                listeningRepository.resolveSpecsForDevice(device)
            }
        } else if (currentDevice != null) {
            listeningRepository.updateDeviceState(currentDevice!!.copy(isConnected = false))
            currentDevice = null
        }
    }

    private fun detectCurrentDevice(): DeviceState? {
        val outputs = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        val deviceInfo = outputs.firstOrNull { info ->
            info.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP ||
                info.type == AudioDeviceInfo.TYPE_BLUETOOTH_SCO ||
                info.type == AudioDeviceInfo.TYPE_WIRED_HEADPHONES ||
                info.type == AudioDeviceInfo.TYPE_WIRED_HEADSET ||
                info.type == AudioDeviceInfo.TYPE_USB_HEADSET
        } ?: return null

        val name = deviceInfo.productName?.toString()?.trim().orEmpty().ifBlank { "Unknown" }
        val address = if (
            deviceInfo.type == AudioDeviceInfo.TYPE_BLUETOOTH_A2DP ||
            deviceInfo.type == AudioDeviceInfo.TYPE_BLUETOOTH_SCO
        ) {
            resolveBluetoothAddress(name) ?: "bt:$name"
        } else {
            "wired:$name"
        }

        return DeviceState(address = address, name = name, isConnected = true)
    }

    private fun resolveBluetoothAddress(deviceName: String): String? {
        return try {
            val manager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
            val adapter = manager?.adapter ?: return null
            adapter.bondedDevices.firstOrNull { it.name == deviceName }?.address
        } catch (_: SecurityException) {
            null
        }
    }

    private fun currentVolumeFraction(): Double {
        val current = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC).toDouble()
        val max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC).toDouble()
        if (max <= 0.0) return 0.0
        return (current / max).coerceIn(0.0, 1.0)
    }

    private fun selectPrimaryConfig(configs: List<AudioPlaybackConfiguration>): AudioPlaybackConfiguration {
        return configs.firstOrNull { config ->
            config.audioAttributes.contentType == AudioAttributes.CONTENT_TYPE_MUSIC
        } ?: configs.firstOrNull { config ->
            config.audioAttributes.contentType == AudioAttributes.CONTENT_TYPE_MOVIE
        } ?: configs.firstOrNull { config ->
            config.audioAttributes.usage == AudioAttributes.USAGE_MEDIA
        } ?: configs.first()
    }

    private fun resolveContentType(attributes: AudioAttributes?): String {
        val contentType = attributes?.contentType ?: AudioAttributes.CONTENT_TYPE_UNKNOWN
        return when (contentType) {
            AudioAttributes.CONTENT_TYPE_MUSIC -> "Music"
            AudioAttributes.CONTENT_TYPE_MOVIE -> "Video"
            AudioAttributes.CONTENT_TYPE_SPEECH -> "Speech"
            AudioAttributes.CONTENT_TYPE_SONIFICATION -> "Other"
            else -> when (attributes?.usage) {
                AudioAttributes.USAGE_GAME -> "Game"
                AudioAttributes.USAGE_MEDIA -> "Media"
                AudioAttributes.USAGE_ASSISTANCE_NAVIGATION_GUIDANCE -> "Navigation"
                AudioAttributes.USAGE_ASSISTANCE_ACCESSIBILITY -> "Accessibility"
                else -> "Other"
            }
        }
    }

    private fun resolveAppInfo(uid: Int): AppInfo? {
        return try {
            val packageManager = context.packageManager
            val packages = packageManager.getPackagesForUid(uid) ?: return null
            val packageName = packages.firstOrNull() ?: return null
            val label = resolveAppLabel(packageName)
            AppInfo(packageName = packageName, label = label ?: packageName)
        } catch (_: Exception) {
            null
        }
    }

    private fun resolveAppInfoFromConfig(config: AudioPlaybackConfiguration): AppInfo? {
        val packageName = resolveClientPackageName(config)
        if (!packageName.isNullOrBlank()) {
            val label = resolveAppLabel(packageName)
            return AppInfo(packageName = packageName, label = label ?: packageName)
        }
        val uid = resolveClientUid(config) ?: return null
        return resolveAppInfo(uid)
    }

    private fun resolveClientUid(config: AudioPlaybackConfiguration): Int? {
        return try {
            val method = AudioPlaybackConfiguration::class.java.getMethod("getClientUid")
            method.invoke(config) as? Int
        } catch (_: Exception) {
            null
        }
    }

    private fun resolveClientPackageName(config: AudioPlaybackConfiguration): String? {
        return try {
            val method = AudioPlaybackConfiguration::class.java.getMethod("getClientPackageName")
            method.invoke(config) as? String
        } catch (_: Exception) {
            null
        }
    }

    private fun resolveAppLabel(packageName: String): String? {
        return try {
            val packageManager = context.packageManager
            val appInfo = packageManager.getApplicationInfo(packageName, 0)
            packageManager.getApplicationLabel(appInfo).toString()
        } catch (_: Exception) {
            null
        }
    }

    private fun isConfigActive(config: AudioPlaybackConfiguration): Boolean {
        return try {
            val method = AudioPlaybackConfiguration::class.java.getMethod("isActive")
            method.invoke(config) as? Boolean ?: false
        } catch (_: Exception) {
            try {
                val method = AudioPlaybackConfiguration::class.java.getMethod("getPlayerState")
                val state = method.invoke(config) as? Int ?: return false
                state == 2
            } catch (_: Exception) {
                false
            }
        }
    }

    private data class AppInfo(
        val packageName: String,
        val label: String
    )

    private data class ActiveSession(
        val device: DeviceState,
        val contentType: String?,
        val sourceApp: String?,
        val sourcePackage: String?,
        val startTimeMillis: Long,
        val volumes: MutableList<Double> = mutableListOf()
    )

    companion object {
        private const val SAMPLE_INTERVAL_MS = 3_000L
        private const val DEVICE_POLL_INTERVAL_MS = 30_000L
        private const val RUNNING_CHUNK_SAVE_MS = 15_000L
        private const val MIN_RUNNING_CHUNK_MINUTES = 0.08
        private const val MIN_FINAL_CHUNK_MINUTES = 0.03
    }
}
