package com.safesound.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.safesound.app.data.model.BluetoothDeviceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BluetoothDeviceDao {
    @Query("SELECT * FROM bluetooth_devices WHERE address = :address")
    suspend fun get(address: String): BluetoothDeviceEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(device: BluetoothDeviceEntity)

    @Query("SELECT * FROM bluetooth_devices WHERE address = :address")
    fun observeDevice(address: String): Flow<BluetoothDeviceEntity?>

    @Query("SELECT * FROM bluetooth_devices WHERE isConnected = 1 ORDER BY lastSeenMillis DESC LIMIT 1")
    fun observeConnectedDevice(): Flow<BluetoothDeviceEntity?>

    @Query("SELECT * FROM bluetooth_devices ORDER BY lastSeenMillis DESC LIMIT 1")
    fun observeMostRecentDevice(): Flow<BluetoothDeviceEntity?>
}
