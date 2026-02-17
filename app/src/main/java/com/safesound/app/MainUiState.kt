package com.safesound.app

import com.safesound.app.data.model.DeviceState
import com.safesound.app.data.model.EarphoneSpecEntity
import com.safesound.app.data.model.PlaybackInfo

data class MainUiState(
    val currentDevice: DeviceState? = null,
    val currentSpec: EarphoneSpecEntity? = null,
    val todayDosePercent: Double = 0.0,
    val todayRiskPercent: Double = 0.0,
    val lastSyncStatus: String = "Not synced",
    val autoStartEnabled: Boolean = true,
    val batteryCardDismissed: Boolean = false,
    val playbackInfo: PlaybackInfo = PlaybackInfo.inactive()
)
