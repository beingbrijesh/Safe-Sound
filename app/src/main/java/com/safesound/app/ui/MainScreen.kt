package com.safesound.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.safesound.app.MainViewModel
import com.safesound.app.util.BatteryOptimizationHelper

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onStartMonitoring: () -> Unit,
    onStopMonitoring: () -> Unit,
    onSyncNow: () -> Unit,
    missingPermissions: List<String>
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "SafeSound",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold
        )

        if (missingPermissions.isNotEmpty()) {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Permissions Needed",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Enable Bluetooth and notifications for accurate monitoring.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Current Device", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = uiState.currentDevice?.name ?: "No earphones detected",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = uiState.lastSyncStatus,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Playback Source", style = MaterialTheme.typography.titleMedium)
                val playbackInfo = uiState.playbackInfo
                if (!playbackInfo.active) {
                    Text(text = "No active playback detected.", style = MaterialTheme.typography.bodyMedium)
                } else {
                    Text(
                        text = "Type: ${playbackInfo.contentType ?: "Other"}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    val appLabel = playbackInfo.sourceApp ?: playbackInfo.sourcePackage ?: "Unknown app"
                    Text(
                        text = "App: $appLabel",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Risk Today", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "${uiState.todayRiskPercent.toInt()}%",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Exposure used: ${uiState.todayDosePercent.toInt()}% of daily safe limit",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Device Specs", style = MaterialTheme.typography.titleMedium)
                val spec = uiState.currentSpec
                if (spec == null) {
                    Text(
                        text = "Specs not cached yet. Tap Sync to fetch from official sources.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                } else {
                    Text(text = "Driver: ${spec.driverSizeMm ?: "?"} mm", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Frequency: ${spec.frequencyLowHz ?: "?"} - ${spec.frequencyHighHz ?: "?"} Hz")
                    Text(text = "Impedance: ${spec.impedanceOhm ?: "?"} ohm")
                    Text(text = "Sensitivity: ${spec.sensitivityDb ?: "?"} dB")
                    Text(text = "Power: ${spec.powerMw ?: "?"} mW")
                    Text(text = "Source: ${spec.sourceName ?: "Unknown"}")
                }
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Best Practices", style = MaterialTheme.typography.titleMedium)
                Text(text = "- Keep volume below 60% when possible.")
                Text(text = "- Take a 5 minute break every 30 minutes.")
                Text(text = "- Use noise isolation instead of higher volume.")
                Text(text = "- Shorten sessions if risk exceeds 100%.")
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Background Monitoring", style = MaterialTheme.typography.titleMedium)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Auto-start on boot/connect", style = MaterialTheme.typography.bodyMedium)
                    Switch(
                        checked = uiState.autoStartEnabled,
                        onCheckedChange = { viewModel.setAutoStartEnabled(it) }
                    )
                }
                Text(
                    text = "SafeSound will resume monitoring when your headphones reconnect.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Card {
            val isWhitelisted = BatteryOptimizationHelper.isIgnoringBatteryOptimizations(context)
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Battery Optimization", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = if (isWhitelisted) {
                        "SafeSound is already allowed to run in background."
                    } else {
                        "Allow SafeSound in battery settings to prevent monitoring from stopping."
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(
                        onClick = {
                            val intent = BatteryOptimizationHelper.buildRequestIntent(context)
                                ?: BatteryOptimizationHelper.buildSettingsIntent()
                            context.startActivity(intent)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = if (isWhitelisted) "Review Settings" else "Allow in Settings")
                    }
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = onStartMonitoring, modifier = Modifier.weight(1f)) {
                Text(text = "Start Monitoring")
            }
            Button(onClick = onStopMonitoring, modifier = Modifier.weight(1f)) {
                Text(text = "Stop")
            }
        }

        Button(onClick = onSyncNow, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sync Paired Devices")
        }
    }
}
