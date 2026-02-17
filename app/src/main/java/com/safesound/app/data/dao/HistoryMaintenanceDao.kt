package com.safesound.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.safesound.app.data.model.ListeningHistoryEntity
import com.safesound.app.data.model.ListeningSessionEntity

@Dao
interface HistoryMaintenanceDao {
    @Query("SELECT * FROM listening_sessions WHERE startTimeMillis < :cutoff")
    suspend fun getSessionsBefore(cutoff: Long): List<ListeningSessionEntity>

    @Insert
    suspend fun insertHistory(entries: List<ListeningHistoryEntity>)

    @Query("DELETE FROM listening_sessions WHERE startTimeMillis < :cutoff")
    suspend fun deleteSessionsBefore(cutoff: Long): Int

    @Transaction
    suspend fun compactOldSessions(cutoff: Long): Int {
        val sessions = getSessionsBefore(cutoff)
        if (sessions.isEmpty()) return 0
        val history = sessions.map { session ->
            ListeningHistoryEntity(
                startTimeMillis = session.startTimeMillis,
                endTimeMillis = session.endTimeMillis,
                averageVolume = session.averageVolume
            )
        }
        insertHistory(history)
        return deleteSessionsBefore(cutoff)
    }
}
