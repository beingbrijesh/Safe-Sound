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

    suspend fun resolveAndCacheDevice(device: DeviceState): EarphoneSpecEntity? {
        val normalizedName = DeviceNameParser.normalize(device.name)
        val existingDevice = deviceDao.get(device.address)
        if (existingDevice?.specId != null) {
            val cachedSpec = earphoneSpecDao.getById(existingDevice.specId)
            if (cachedSpec != null && isSpecCompatible(normalizedName, cachedSpec)) {
                return cachedSpec
            }
            deviceDao.upsert(
                existingDevice.copy(
                    name = device.name,
                    lastSeenMillis = System.currentTimeMillis(),
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
                    lastSeenMillis = System.currentTimeMillis(),
                    isConnected = device.isConnected,
                    specId = specFromName.id
                )
            )
            return specFromName
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
                lastFetchedMillis = System.currentTimeMillis(),
                calibrationOffsetDb = null
            )
            val newId = earphoneSpecDao.insert(specEntity)
            deviceDao.upsert(
                BluetoothDeviceEntity(
                    address = device.address,
                    name = device.name,
                    lastSeenMillis = System.currentTimeMillis(),
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
            "No official specs found for ${device.name}"
        )
        return null
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
}
