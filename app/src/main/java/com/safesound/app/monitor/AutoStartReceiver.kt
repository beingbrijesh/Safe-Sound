package com.safesound.app.monitor

import android.bluetooth.BluetoothA2dp
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.safesound.app.data.repo.SettingsRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class AutoStartReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val action = intent?.action ?: return
        val shouldStart = when (action) {
            Intent.ACTION_BOOT_COMPLETED,
            Intent.ACTION_MY_PACKAGE_REPLACED -> true
            Intent.ACTION_HEADSET_PLUG -> intent.getIntExtra("state", 0) == 1
            BluetoothDevice.ACTION_ACL_CONNECTED -> true
            BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED -> {
                val state = intent.getIntExtra(BluetoothA2dp.EXTRA_STATE, BluetoothA2dp.STATE_DISCONNECTED)
                state == BluetoothA2dp.STATE_CONNECTED
            }
            else -> false
        }

        if (!shouldStart) return

        val enabled = runBlocking {
            SettingsRepository(context).observeAutoStartEnabled().first()
        }
        if (!enabled) return

        MonitoringController.start(context)
    }
}
