package com.safesound.app.data.repo

import com.safesound.app.data.dao.BluetoothDeviceDao
import com.safesound.app.data.dao.EarphoneSpecDao
import com.safesound.app.data.model.BluetoothDeviceEntity
import com.safesound.app.data.model.DeviceState
import com.safesound.app.data.model.EarphoneSpecEntity
import com.safesound.app.network.SpecRemoteClient
import com.safesound.app.util.DeviceNameParser
import com.safesound.app.util.TimeUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf

@OptIn(ExperimentalCoroutinesApi::class)
class SpecRepository(
    private val earphoneSpecDao: EarphoneSpecDao,
    private val deviceDao: BluetoothDeviceDao,
    private val remoteClient: SpecRemoteClient
) {
    fun observeSpecForDevice(address: String): Flow<EarphoneSpecEntity?> {
        return deviceDao.observeDevice(address).flatMapLatest { device ->
            if (device?.specId == null) {
                flowOf(null)
            } else {
                earphoneSpecDao.observeById(device.specId)
            }
        }
    }

    fun emptySpecFlow(): Flow<EarphoneSpecEntity?> = flowOf(null)

    fun observeLastSyncStatus(): Flow<String> = remoteClient.settingsRepository.observeLastSyncStatus()

    suspend fun resolveAndCacheDevice(
        device: DeviceState,
        forceRefresh: Boolean = false
    ): EarphoneSpecEntity? {
        val normalizedName = DeviceNameParser.normalize(device.name)
        val now = System.currentTimeMillis()
        val existingDevice = deviceDao.get(device.address)
        if (existingDevice?.specId != null) {
            val cachedSpec = earphoneSpecDao.getById(existingDevice.specId)
            if (cachedSpec != null && isSpecCompatible(normalizedName, cachedSpec)) {
                val refreshed = refreshFromRemoteIfNeeded(
                    device = device,
                    displayName = normalizedName,
                    existing = cachedSpec,
                    nowMillis = now,
                    forceRefresh = forceRefresh
                )
                return refreshed ?: cachedSpec
            }
            deviceDao.upsert(
                existingDevice.copy(
                    name = device.name,
                    lastSeenMillis = now,
                    isConnected = device.isConnected,
                    specId = null
                )
            )
        }

        val specFromName = earphoneSpecDao.findByDisplayName(normalizedName)
        if (specFromName != null) {
            deviceDao.upsert(
                BluetoothDeviceEntity(
                    address = device.address,
                    name = device.name,
                    lastSeenMillis = now,
                    isConnected = device.isConnected,
                    specId = specFromName.id
                )
            )
            val refreshed = refreshFromRemoteIfNeeded(
                device = device,
                displayName = normalizedName,
                existing = specFromName,
                nowMillis = now,
                forceRefresh = forceRefresh
            )
            return refreshed ?: specFromName
        }

        val query = DeviceNameParser.buildQuery(device.name)
        val remote = remoteClient.lookup(query)
        if (remote != null) {
            val specEntity = EarphoneSpecEntity(
                brand = remote.brand,
                model = remote.model,
                displayName = normalizedName,
                driverSizeMm = remote.driverSizeMm,
                frequencyLowHz = remote.frequencyLowHz,
                frequencyHighHz = remote.frequencyHighHz,
                impedanceOhm = remote.impedanceOhm,
                sensitivityDb = remote.sensitivityDb,
                powerMw = remote.powerMw,
                sourceName = remote.sourceName,
                sourceUrl = remote.sourceUrl,
                verified = remote.verified,
                lastFetchedMillis = now,
                calibrationOffsetDb = null
            )
            val newId = earphoneSpecDao.insert(specEntity)
            deviceDao.upsert(
                BluetoothDeviceEntity(
                    address = device.address,
                    name = device.name,
                    lastSeenMillis = now,
                    isConnected = device.isConnected,
                    specId = newId
                )
            )
            remoteClient.settingsRepository.setLastSyncStatus(
                "Synced ${device.name} on ${TimeUtils.formatNow()}"
            )
            return earphoneSpecDao.getById(newId)
        }

        remoteClient.settingsRepository.setLastSyncStatus(
            "No trusted specs found for ${device.name}"
        )
        return null
    }

    private suspend fun refreshFromRemoteIfNeeded(
        device: DeviceState,
        displayName: String,
        existing: EarphoneSpecEntity,
        nowMillis: Long,
        forceRefresh: Boolean
    ): EarphoneSpecEntity? {
        if (!shouldRefreshSpec(existing, nowMillis, forceRefresh)) return null
        val query = DeviceNameParser.buildQuery(device.name)
        val remote = remoteClient.lookup(query) ?: return null

        val updated = existing.copy(
            brand = remote.brand ?: existing.brand,
            model = remote.model ?: existing.model,
            displayName = displayName,
            driverSizeMm = remote.driverSizeMm ?: existing.driverSizeMm,
            frequencyLowHz = remote.frequencyLowHz ?: existing.frequencyLowHz,
            frequencyHighHz = remote.frequencyHighHz ?: existing.frequencyHighHz,
            impedanceOhm = remote.impedanceOhm ?: existing.impedanceOhm,
            sensitivityDb = remote.sensitivityDb ?: existing.sensitivityDb,
            powerMw = remote.powerMw ?: existing.powerMw,
            sourceName = remote.sourceName ?: existing.sourceName,
            sourceUrl = remote.sourceUrl ?: existing.sourceUrl,
            verified = remote.verified || existing.verified,
            lastFetchedMillis = nowMillis
        )
        earphoneSpecDao.update(updated)
        remoteClient.settingsRepository.setLastSyncStatus(
            "Refreshed ${device.name} on ${TimeUtils.formatNow()}"
        )
        return earphoneSpecDao.getById(updated.id)
    }

    private fun shouldRefreshSpec(
        spec: EarphoneSpecEntity,
        nowMillis: Long,
        forceRefresh: Boolean
    ): Boolean {
        if (forceRefresh) return true
        val ageMillis = nowMillis - spec.lastFetchedMillis
        if (ageMillis < MIN_REFRESH_GAP_MS) return false
        if (ageMillis > FORCE_REFRESH_AGE_MS) return true
        if (spec.sourceUrl.isNullOrBlank()) return true
        return populatedMetricCount(spec) < MIN_METRIC_COUNT
    }

    private fun populatedMetricCount(spec: EarphoneSpecEntity): Int {
        val values = listOf(
            spec.driverSizeMm,
            spec.frequencyLowHz,
            spec.frequencyHighHz,
            spec.impedanceOhm,
            spec.sensitivityDb,
            spec.powerMw
        )
        return values.count { it != null }
    }

    private fun isSpecCompatible(deviceName: String, spec: EarphoneSpecEntity): Boolean {
        val deviceTokens = tokenize(deviceName)
        val specTokens = tokenize(
            listOfNotNull(spec.displayName, spec.brand, spec.model).joinToString(" ")
        )
        if (deviceTokens.isEmpty() || specTokens.isEmpty()) return false

        val overlap = deviceTokens.count { it in specTokens }
        return overlap >= 2
    }

    private fun tokenize(value: String): Set<String> {
        return value.lowercase()
            .replace("[^a-z0-9]+".toRegex(), " ")
            .trim()
            .split(" ")
            .filter { it.length > 1 }
            .toSet()
    }

    private companion object {
        const val MIN_METRIC_COUNT = 4
        const val MIN_REFRESH_GAP_MS = 24L * 60L * 60L * 1000L
        const val FORCE_REFRESH_AGE_MS = 30L * 24L * 60L * 60L * 1000L
    }
}
