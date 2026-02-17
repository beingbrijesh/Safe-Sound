package com.safesound.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.safesound.app.data.model.ListeningSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ListeningSessionDao {
    @Insert
    suspend fun insert(session: ListeningSessionEntity)

    @Query("SELECT * FROM listening_sessions WHERE startTimeMillis BETWEEN :start AND :end")
    fun observeSessions(start: Long, end: Long): Flow<List<ListeningSessionEntity>>

    @Query("SELECT * FROM listening_sessions WHERE startTimeMillis BETWEEN :start AND :end")
    suspend fun getSessions(start: Long, end: Long): List<ListeningSessionEntity>
}
