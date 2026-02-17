package com.safesound.app.network

import android.Manifest
import android.bluetooth.BluetoothManager
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.safesound.app.SafeSoundApp
import com.safesound.app.data.model.DeviceState
import com.safesound.app.util.TimeUtils

class SpecSyncWorker(
    appContext: android.content.Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val app = applicationContext as SafeSoundApp
        val settings = app.container.settingsRepository

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val granted = ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.BLUETOOTH_CONNECT
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
            if (!granted) {
                settings.setLastSyncStatus("Bluetooth permission required for sync")
                return Result.retry()
            }
        }

        return try {
            val manager = applicationContext.getSystemService(android.content.Context.BLUETOOTH_SERVICE) as? BluetoothManager
            val adapter = manager?.adapter
            if (adapter == null) {
                settings.setLastSyncStatus("No Bluetooth adapter found")
                return Result.success()
            }
            val devices = adapter.bondedDevices
            if (devices.isEmpty()) {
                settings.setLastSyncStatus("No paired Bluetooth devices found")
            }
            devices.forEach { device ->
                val state = DeviceState(
                    address = device.address,
                    name = device.name ?: "Unknown",
                    isConnected = false
                )
                app.container.listeningRepository.updateDeviceState(state)
                app.container.specRepository.resolveAndCacheDevice(
                    state,
                    forceRefresh = true
                )
            }
            settings.setFirstSyncDone(true)
            settings.setLastSyncStatus(
                "Synced ${devices.size} devices on ${TimeUtils.formatNow()}"
            )
            Result.success()
        } catch (se: SecurityException) {
            settings.setLastSyncStatus("Bluetooth permission required for sync")
            Result.retry()
        } catch (_: Exception) {
            settings.setLastSyncStatus("Spec sync failed. Will retry on next connection.")
            Result.retry()
        }
    }
}
