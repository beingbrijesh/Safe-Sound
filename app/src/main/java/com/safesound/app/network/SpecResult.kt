package com.safesound.app.network

data class SpecResult(
    val brand: String?,
    val model: String?,
    val driverSizeMm: Double?,
    val frequencyLowHz: Int?,
    val frequencyHighHz: Int?,
    val impedanceOhm: Double?,
    val sensitivityDb: Double?,
    val powerMw: Double?,
    val sourceName: String?,
    val sourceUrl: String?,
    val verified: Boolean
)
