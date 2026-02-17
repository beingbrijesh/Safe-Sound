package com.safesound.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.safesound.app.data.model.DeviceState
import com.safesound.app.data.model.EarphoneSpecEntity
import com.safesound.app.data.model.PlaybackInfo
import com.safesound.app.data.repo.ListeningRepository
import com.safesound.app.data.repo.SettingsRepository
import com.safesound.app.data.repo.SpecRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModel(
    private val listeningRepository: ListeningRepository,
    private val specRepository: SpecRepository,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    val uiState: StateFlow<MainUiState> = run {
        val currentDeviceFlow = listeningRepository.observeCurrentDevice()
        val currentSpecFlow = currentDeviceFlow.flatMapLatest { deviceState ->
            if (deviceState == null) {
                specRepository.emptySpecFlow()
            } else {
                specRepository.observeSpecForDevice(deviceState.address)
            }
        }
        val doseFlow = listeningRepository.observeTodayDosePercent()
        val riskFlow = listeningRepository.observeTodayRiskPercent()
        val syncStatusFlow = specRepository.observeLastSyncStatus()
        val autoStartFlow = settingsRepository.observeAutoStartEnabled()
        val batteryCardDismissedFlow = settingsRepository.observeBatteryCardDismissed()
        val playbackFlow = listeningRepository.observePlaybackInfo()

        combine(
            currentDeviceFlow,
            currentSpecFlow,
            doseFlow,
            riskFlow,
            syncStatusFlow,
            autoStartFlow,
            batteryCardDismissedFlow,
            playbackFlow
        ) { values ->
            val device = values[0] as DeviceState?
            val spec = values[1] as EarphoneSpecEntity?
            val dose = values[2] as Double
            val risk = values[3] as Double
            val syncStatus = values[4] as String
            val autoStart = values[5] as Boolean
            val batteryCardDismissed = values[6] as Boolean
            val playbackInfo = values[7] as PlaybackInfo
            MainUiState(
                currentDevice = device,
                currentSpec = spec,
                todayDosePercent = dose,
                todayRiskPercent = risk,
                lastSyncStatus = syncStatus,
                autoStartEnabled = autoStart,
                batteryCardDismissed = batteryCardDismissed,
                playbackInfo = playbackInfo
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainUiState()
        )
    }

    fun setAutoStartEnabled(enabled: Boolean) {
        viewModelScope.launch {
            settingsRepository.setAutoStartEnabled(enabled)
        }
    }

    fun setBatteryCardDismissed(dismissed: Boolean) {
        viewModelScope.launch {
            settingsRepository.setBatteryCardDismissed(dismissed)
        }
    }

    class Factory(private val container: AppContainer) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(
                    listeningRepository = container.listeningRepository,
                    specRepository = container.specRepository,
                    settingsRepository = container.settingsRepository
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
