package com.safesound.app

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.lifecycleScope
import com.safesound.app.monitor.MonitoringController
import com.safesound.app.network.MaintenanceScheduler
import com.safesound.app.network.SyncScheduler
import com.safesound.app.ui.MainScreen
import com.safesound.app.ui.SafeSoundTheme
import com.safesound.app.util.PermissionHelper
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModel.Factory((application as SafeSoundApp).container)
    }

    private val missingPermissionsState = mutableStateOf<List<String>>(emptyList())

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { _ ->
        missingPermissionsState.value = PermissionHelper.getMissingPermissions(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestCorePermissions()
        missingPermissionsState.value = PermissionHelper.getMissingPermissions(this)

        lifecycleScope.launch {
            SyncScheduler.scheduleFirstRunSyncIfNeeded(this@MainActivity)
            val settings = (application as SafeSoundApp).container.settingsRepository
            if (settings.observeAutoStartEnabled().first()) {
                MonitoringController.start(this@MainActivity)
            }
        }

        MaintenanceScheduler.scheduleHistoryTrim(this)

        setContent {
            SafeSoundTheme {
                MainScreen(
                    viewModel = viewModel,
                    onStartMonitoring = { MonitoringController.start(this) },
                    onStopMonitoring = { MonitoringController.stop(this) },
                    onSyncNow = { lifecycleScope.launch { SyncScheduler.enqueueManualSync(this@MainActivity) } },
                    missingPermissions = missingPermissionsState.value
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        missingPermissionsState.value = PermissionHelper.getMissingPermissions(this)
    }

    private fun requestCorePermissions() {
        val permissions = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions += Manifest.permission.BLUETOOTH_CONNECT
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissions += Manifest.permission.POST_NOTIFICATIONS
        }
        if (permissions.isNotEmpty()) {
            val missing = permissions.filter {
                !PermissionHelper.hasPermission(this, it)
            }
            if (missing.isNotEmpty()) {
                permissionLauncher.launch(missing.toTypedArray())
            }
        }
    }
}
