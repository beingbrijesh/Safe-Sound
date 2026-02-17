package com.safesound.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.safesound.app.data.model.EarphoneSpecEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EarphoneSpecDao {
    @Query("SELECT * FROM earphone_specs WHERE id = :id")
    suspend fun getById(id: Long): EarphoneSpecEntity?

    @Query("SELECT * FROM earphone_specs WHERE displayName = :name LIMIT 1")
    suspend fun findByDisplayName(name: String): EarphoneSpecEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spec: EarphoneSpecEntity): Long

    @Update
    suspend fun update(spec: EarphoneSpecEntity)

    @Query("SELECT * FROM earphone_specs WHERE id = :id")
    fun observeById(id: Long): Flow<EarphoneSpecEntity?>
}
