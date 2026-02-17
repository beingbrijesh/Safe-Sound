package com.safesound.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "earphone_specs")
data class EarphoneSpecEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val brand: String?,
    val model: String?,
    val displayName: String,
    val driverSizeMm: Double?,
    val frequencyLowHz: Int?,
    val frequencyHighHz: Int?,
    val impedanceOhm: Double?,
    val sensitivityDb: Double?,
    val powerMw: Double?,
    val sourceName: String?,
    val sourceUrl: String?,
    val verified: Boolean,
    val lastFetchedMillis: Long,
    val calibrationOffsetDb: Double?
)
