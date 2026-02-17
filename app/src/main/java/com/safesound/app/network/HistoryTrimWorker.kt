package com.safesound.app.network

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.safesound.app.SafeSoundApp

class HistoryTrimWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        val app = applicationContext as SafeSoundApp
        return try {
            app.container.listeningRepository.compactHistory()
            Result.success()
        } catch (_: Exception) {
            Result.retry()
        }
    }
}
