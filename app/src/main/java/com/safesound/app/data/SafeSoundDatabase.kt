package com.safesound.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.safesound.app.data.dao.BluetoothDeviceDao
import com.safesound.app.data.dao.EarphoneSpecDao
import com.safesound.app.data.dao.HistoryMaintenanceDao
import com.safesound.app.data.dao.ListeningSessionDao
import com.safesound.app.data.model.BluetoothDeviceEntity
import com.safesound.app.data.model.EarphoneSpecEntity
import com.safesound.app.data.model.ListeningHistoryEntity
import com.safesound.app.data.model.ListeningSessionEntity

@Database(
    entities = [
        EarphoneSpecEntity::class,
        BluetoothDeviceEntity::class,
        ListeningSessionEntity::class,
        ListeningHistoryEntity::class
    ],
    version = 3,
    exportSchema = false
)
abstract class SafeSoundDatabase : RoomDatabase() {
    abstract fun earphoneSpecDao(): EarphoneSpecDao
    abstract fun deviceDao(): BluetoothDeviceDao
    abstract fun listeningSessionDao(): ListeningSessionDao
    abstract fun historyMaintenanceDao(): HistoryMaintenanceDao

    companion object {
        @Volatile
        private var INSTANCE: SafeSoundDatabase? = null

        fun getInstance(context: Context): SafeSoundDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SafeSoundDatabase::class.java,
                    "safesound.db"
                ).fallbackToDestructiveMigration(true).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
