package com.safesound.app.util

import kotlin.math.pow

class DoseCalculator {
    private val referenceHoursPerWeek = 40.0
    private val displayWindowDays = 1.0 // App UI shows a daily limit.

    fun safeHoursAtDb(db: Double): Double {
        // WHO-style exchange rate: every +3 dB halves safe exposure time.
        val weeklySafeHours = referenceHoursPerWeek * 2.0.pow((80.0 - db) / 3.0)
        return weeklySafeHours * (displayWindowDays / 7.0)
    }

    fun dosePercentForMinutes(db: Double, minutes: Double): Double {
        val safeHours = safeHoursAtDb(db)
        val hours = minutes / 60.0
        return if (safeHours <= 0.0) 100.0 else (hours / safeHours) * 100.0
    }
}
