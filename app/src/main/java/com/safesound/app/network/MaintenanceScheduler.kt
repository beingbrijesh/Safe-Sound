package com.safesound.app.network

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

object MaintenanceScheduler {
    private const val HISTORY_TRIM_WORK = "history_trim_work"

    fun scheduleHistoryTrim(context: Context) {
        val request = PeriodicWorkRequestBuilder<HistoryTrimWorker>(
            1, TimeUnit.DAYS
        ).build()

        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                HISTORY_TRIM_WORK,
                ExistingPeriodicWorkPolicy.KEEP,
                request
            )
    }
}
