package com.safesound.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listening_sessions")
data class ListeningSessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val deviceAddress: String,
    val deviceName: String,
    val contentType: String?,
    val sourceApp: String?,
    val sourcePackage: String?,
    val startTimeMillis: Long,
    val endTimeMillis: Long,
    val averageVolume: Double,
    val estimatedDb: Double,
    val dosePercent: Double
)
