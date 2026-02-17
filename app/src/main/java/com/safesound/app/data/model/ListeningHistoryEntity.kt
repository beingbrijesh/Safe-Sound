package com.safesound.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listening_history_compact")
data class ListeningHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val startTimeMillis: Long,
    val endTimeMillis: Long,
    val averageVolume: Double
)
