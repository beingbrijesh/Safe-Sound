package com.safesound.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bluetooth_devices")
data class BluetoothDeviceEntity(
    @PrimaryKey
    val address: String,
    val name: String?,
    val lastSeenMillis: Long,
    val isConnected: Boolean,
    val specId: Long?
)
