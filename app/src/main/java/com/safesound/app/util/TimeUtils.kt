package com.safesound.app.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object TimeUtils {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

    fun startOfTodayMillis(): Long {
        val today = LocalDate.now()
        return today.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }

    fun endOfTodayMillis(): Long {
        val tomorrow = LocalDate.now().plusDays(1)
        return tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli() - 1
    }

    fun formatNow(): String {
        val now = Instant.now().atZone(ZoneId.systemDefault())
        return formatter.format(now)
    }

    fun millisDaysAgo(days: Int): Long {
        return Instant.now()
            .minusSeconds(days.toLong() * 24L * 60L * 60L)
            .toEpochMilli()
    }
}
