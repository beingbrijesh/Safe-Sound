package com.safesound.app.data.repo

import com.safesound.app.data.dao.BluetoothDeviceDao
import com.safesound.app.data.dao.HistoryMaintenanceDao
import com.safesound.app.data.dao.ListeningSessionDao
import com.safesound.app.data.model.BluetoothDeviceEntity
import com.safesound.app.data.model.DeviceState
import com.safesound.app.data.model.ListeningSessionEntity
import com.safesound.app.data.model.PlaybackInfo
import com.safesound.app.ml.RiskModel
import com.safesound.app.util.TimeUtils
import com.safesound.app.util.VolumeEstimator
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalCoroutinesApi::class)
class ListeningRepository(
    private val listeningSessionDao: ListeningSessionDao,
    private val deviceDao: BluetoothDeviceDao,
    private val specRepository: SpecRepository,
    private val settingsRepository: SettingsRepository,
    private val historyMaintenanceDao: HistoryMaintenanceDao,
    private val doseCalculator: com.safesound.app.util.DoseCalculator,
    private val volumeEstimator: VolumeEstimator,
    private val riskModel: RiskModel
) {
    fun observeCurrentDevice(): Flow<DeviceState?> {
        return deviceDao.observeConnectedDevice().flatMapLatest { connected ->
            if (connected != null) {
                flowOf(connected)
            } else {
                deviceDao.observeMostRecentDevice()
            }
        }.map { entity ->
            entity?.let {
                DeviceState(
                    address = it.address,
                    name = it.name ?: "Unknown",
                    isConnected = it.isConnected
                )
            }
        }
    }

    fun observeTodayDosePercent(): Flow<Double> {
        val start = TimeUtils.startOfTodayMillis()
        val end = TimeUtils.endOfTodayMillis()
        return listeningSessionDao.observeSessions(start, end).map { sessions ->
            sessions.sumOf { it.dosePercent }.coerceAtMost(200.0)
        }
    }

    fun observeTodayRiskPercent(): Flow<Double> {
        val start = TimeUtils.startOfTodayMillis()
        val end = TimeUtils.endOfTodayMillis()
        return listeningSessionDao.observeSessions(start, end).map { sessions ->
            if (sessions.isEmpty()) {
                0.0
            } else {
                val weightedDurations = sessions.map { session ->
                    ((session.endTimeMillis - session.startTimeMillis).toDouble() / 60000.0)
                        .coerceAtLeast(0.0)
                }
                val totalMinutes = weightedDurations.sum().coerceAtLeast(0.0001)
                val dosePercent = sessions.sumOf { it.dosePercent }.coerceAtLeast(0.0)
                val weightedVolume = sessions.zip(weightedDurations).sumOf { (session, minutes) ->
                    session.averageVolume * minutes
                } / totalMinutes
                val weightedDb = sessions.zip(weightedDurations).sumOf { (session, minutes) ->
                    session.estimatedDb * minutes
                } / totalMinutes

                riskModel.predictRiskPercent(
                    RiskModel.RiskFeatures(
                        averageVolumeFraction = weightedVolume,
                        totalDurationMinutes = totalMinutes,
                        averageDb = weightedDb,
                        dosePercent = dosePercent
                    )
                ).coerceIn(0.0, 200.0)
            }
        }
    }

    fun observePlaybackInfo(): Flow<PlaybackInfo> {
        return settingsRepository.observePlaybackInfo()
    }

    suspend fun recordSession(session: ListeningSessionEntity) {
        listeningSessionDao.insert(session)
    }

    suspend fun updateDeviceState(device: DeviceState) {
        deviceDao.upsert(
            BluetoothDeviceEntity(
                address = device.address,
                name = device.name,
                lastSeenMillis = System.currentTimeMillis(),
                isConnected = device.isConnected,
                specId = deviceDao.get(device.address)?.specId
            )
        )
    }

    suspend fun resolveSpecsForDevice(device: DeviceState, forceRefresh: Boolean = false) {
        specRepository.resolveAndCacheDevice(device, forceRefresh)
    }

    suspend fun updatePlaybackInfo(info: PlaybackInfo) {
        settingsRepository.setPlaybackInfo(info)
    }

    suspend fun compactHistory(daysToKeep: Int = 7): Int {
        val cutoff = TimeUtils.millisDaysAgo(daysToKeep)
        return historyMaintenanceDao.compactOldSessions(cutoff)
    }

    fun estimateDbFromVolume(volumeFraction: Double, calibrationOffsetDb: Double?): Double {
        return volumeEstimator.estimateDb(volumeFraction, calibrationOffsetDb)
    }

    fun calculateDosePercent(estimatedDb: Double, durationMinutes: Double): Double {
        return doseCalculator.dosePercentForMinutes(estimatedDb, durationMinutes)
    }
}
