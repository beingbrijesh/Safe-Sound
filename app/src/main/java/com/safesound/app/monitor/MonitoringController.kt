package com.safesound.app.monitor

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat

object MonitoringController {
    fun start(context: Context) {
        val intent = Intent(context, MonitoringService::class.java)
        ContextCompat.startForegroundService(context, intent)
    }

    fun stop(context: Context) {
        val intent = Intent(context, MonitoringService::class.java)
        context.stopService(intent)
    }
}
