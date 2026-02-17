package com.safesound.app.network

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.safesound.app.SafeSoundApp

object SyncScheduler {
    private const val FIRST_RUN_SYNC = "first_run_spec_sync"
    private const val MANUAL_SYNC = "manual_spec_sync"

    suspend fun scheduleFirstRunSyncIfNeeded(context: Context) {
        val app = context.applicationContext as SafeSoundApp
        val settings = app.container.settingsRepository
        if (!settings.isFirstSyncDone()) {
            enqueueWork(context, FIRST_RUN_SYNC, ExistingWorkPolicy.KEEP)
        }
    }

    suspend fun enqueueManualSync(context: Context) {
        enqueueWork(context, MANUAL_SYNC, ExistingWorkPolicy.REPLACE)
    }

    private fun enqueueWork(context: Context, name: String, policy: ExistingWorkPolicy) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request = OneTimeWorkRequestBuilder<SpecSyncWorker>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context)
            .enqueueUniqueWork(name, policy, request)
    }
}
