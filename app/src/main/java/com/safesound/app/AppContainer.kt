package com.safesound.app

import android.content.Context
import com.safesound.app.data.SafeSoundDatabase
import com.safesound.app.data.repo.ListeningRepository
import com.safesound.app.data.repo.SettingsRepository
import com.safesound.app.data.repo.SpecRepository
import com.safesound.app.ml.RiskModel
import com.safesound.app.network.SpecRemoteClient
import com.safesound.app.util.DoseCalculator
import com.safesound.app.util.VolumeEstimator

class AppContainer(context: Context) {
    private val database = SafeSoundDatabase.getInstance(context)

    val settingsRepository = SettingsRepository(context)
    private val specRemoteClient = SpecRemoteClient(settingsRepository)
    val specRepository = SpecRepository(
        earphoneSpecDao = database.earphoneSpecDao(),
        deviceDao = database.deviceDao(),
        remoteClient = specRemoteClient
    )

    private val doseCalculator = DoseCalculator()
    private val volumeEstimator = VolumeEstimator()
    private val riskModel = RiskModel(context)

    val listeningRepository = ListeningRepository(
        listeningSessionDao = database.listeningSessionDao(),
        deviceDao = database.deviceDao(),
        specRepository = specRepository,
        settingsRepository = settingsRepository,
        historyMaintenanceDao = database.historyMaintenanceDao(),
        doseCalculator = doseCalculator,
        volumeEstimator = volumeEstimator,
        riskModel = riskModel
    )
}
