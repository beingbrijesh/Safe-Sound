package com.safesound.app.util

class VolumeEstimator {
    fun estimateDb(volumeFraction: Double, calibrationOffsetDb: Double?): Double {
        val clamped = volumeFraction.coerceIn(0.0, 1.0)
        // Simple linear estimate: 0% -> 60 dB, 100% -> 100 dB.
        val base = 60.0 + (40.0 * clamped)
        val calibrated = calibrationOffsetDb?.let { base + it } ?: base
        return calibrated.coerceIn(40.0, 110.0)
    }
}
