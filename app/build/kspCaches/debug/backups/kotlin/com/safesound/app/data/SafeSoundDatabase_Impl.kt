package com.safesound.app.`data`

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.safesound.app.`data`.dao.BluetoothDeviceDao
import com.safesound.app.`data`.dao.BluetoothDeviceDao_Impl
import com.safesound.app.`data`.dao.EarphoneSpecDao
import com.safesound.app.`data`.dao.EarphoneSpecDao_Impl
import com.safesound.app.`data`.dao.HistoryMaintenanceDao
import com.safesound.app.`data`.dao.HistoryMaintenanceDao_Impl
import com.safesound.app.`data`.dao.ListeningSessionDao
import com.safesound.app.`data`.dao.ListeningSessionDao_Impl
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class SafeSoundDatabase_Impl : SafeSoundDatabase() {
  private val _earphoneSpecDao: Lazy<EarphoneSpecDao> = lazy {
    EarphoneSpecDao_Impl(this)
  }

  private val _bluetoothDeviceDao: Lazy<BluetoothDeviceDao> = lazy {
    BluetoothDeviceDao_Impl(this)
  }

  private val _listeningSessionDao: Lazy<ListeningSessionDao> = lazy {
    ListeningSessionDao_Impl(this)
  }

  private val _historyMaintenanceDao: Lazy<HistoryMaintenanceDao> = lazy {
    HistoryMaintenanceDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(3, "6639adcbdfc08ea5a181b317e26d1182", "0f8c6f12271118e60ca40fc59db6d17e") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `earphone_specs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `brand` TEXT, `model` TEXT, `displayName` TEXT NOT NULL, `driverSizeMm` REAL, `frequencyLowHz` INTEGER, `frequencyHighHz` INTEGER, `impedanceOhm` REAL, `sensitivityDb` REAL, `powerMw` REAL, `sourceName` TEXT, `sourceUrl` TEXT, `verified` INTEGER NOT NULL, `lastFetchedMillis` INTEGER NOT NULL, `calibrationOffsetDb` REAL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `bluetooth_devices` (`address` TEXT NOT NULL, `name` TEXT, `lastSeenMillis` INTEGER NOT NULL, `isConnected` INTEGER NOT NULL, `specId` INTEGER, PRIMARY KEY(`address`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `listening_sessions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deviceAddress` TEXT NOT NULL, `deviceName` TEXT NOT NULL, `contentType` TEXT, `sourceApp` TEXT, `sourcePackage` TEXT, `startTimeMillis` INTEGER NOT NULL, `endTimeMillis` INTEGER NOT NULL, `averageVolume` REAL NOT NULL, `estimatedDb` REAL NOT NULL, `dosePercent` REAL NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `listening_history_compact` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `startTimeMillis` INTEGER NOT NULL, `endTimeMillis` INTEGER NOT NULL, `averageVolume` REAL NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6639adcbdfc08ea5a181b317e26d1182')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `earphone_specs`")
        connection.execSQL("DROP TABLE IF EXISTS `bluetooth_devices`")
        connection.execSQL("DROP TABLE IF EXISTS `listening_sessions`")
        connection.execSQL("DROP TABLE IF EXISTS `listening_history_compact`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection): RoomOpenDelegate.ValidationResult {
        val _columnsEarphoneSpecs: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsEarphoneSpecs.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("brand", TableInfo.Column("brand", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("model", TableInfo.Column("model", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("displayName", TableInfo.Column("displayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("driverSizeMm", TableInfo.Column("driverSizeMm", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("frequencyLowHz", TableInfo.Column("frequencyLowHz", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("frequencyHighHz", TableInfo.Column("frequencyHighHz", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("impedanceOhm", TableInfo.Column("impedanceOhm", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("sensitivityDb", TableInfo.Column("sensitivityDb", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("powerMw", TableInfo.Column("powerMw", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("sourceName", TableInfo.Column("sourceName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("sourceUrl", TableInfo.Column("sourceUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("verified", TableInfo.Column("verified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("lastFetchedMillis", TableInfo.Column("lastFetchedMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsEarphoneSpecs.put("calibrationOffsetDb", TableInfo.Column("calibrationOffsetDb", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysEarphoneSpecs: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesEarphoneSpecs: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoEarphoneSpecs: TableInfo = TableInfo("earphone_specs", _columnsEarphoneSpecs, _foreignKeysEarphoneSpecs, _indicesEarphoneSpecs)
        val _existingEarphoneSpecs: TableInfo = read(connection, "earphone_specs")
        if (!_infoEarphoneSpecs.equals(_existingEarphoneSpecs)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |earphone_specs(com.safesound.app.data.model.EarphoneSpecEntity).
              | Expected:
              |""".trimMargin() + _infoEarphoneSpecs + """
              |
              | Found:
              |""".trimMargin() + _existingEarphoneSpecs)
        }
        val _columnsBluetoothDevices: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsBluetoothDevices.put("address", TableInfo.Column("address", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBluetoothDevices.put("name", TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBluetoothDevices.put("lastSeenMillis", TableInfo.Column("lastSeenMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBluetoothDevices.put("isConnected", TableInfo.Column("isConnected", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBluetoothDevices.put("specId", TableInfo.Column("specId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysBluetoothDevices: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesBluetoothDevices: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoBluetoothDevices: TableInfo = TableInfo("bluetooth_devices", _columnsBluetoothDevices, _foreignKeysBluetoothDevices, _indicesBluetoothDevices)
        val _existingBluetoothDevices: TableInfo = read(connection, "bluetooth_devices")
        if (!_infoBluetoothDevices.equals(_existingBluetoothDevices)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |bluetooth_devices(com.safesound.app.data.model.BluetoothDeviceEntity).
              | Expected:
              |""".trimMargin() + _infoBluetoothDevices + """
              |
              | Found:
              |""".trimMargin() + _existingBluetoothDevices)
        }
        val _columnsListeningSessions: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsListeningSessions.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("deviceAddress", TableInfo.Column("deviceAddress", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("deviceName", TableInfo.Column("deviceName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("contentType", TableInfo.Column("contentType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("sourceApp", TableInfo.Column("sourceApp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("sourcePackage", TableInfo.Column("sourcePackage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("startTimeMillis", TableInfo.Column("startTimeMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("endTimeMillis", TableInfo.Column("endTimeMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("averageVolume", TableInfo.Column("averageVolume", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("estimatedDb", TableInfo.Column("estimatedDb", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningSessions.put("dosePercent", TableInfo.Column("dosePercent", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysListeningSessions: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesListeningSessions: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoListeningSessions: TableInfo = TableInfo("listening_sessions", _columnsListeningSessions, _foreignKeysListeningSessions, _indicesListeningSessions)
        val _existingListeningSessions: TableInfo = read(connection, "listening_sessions")
        if (!_infoListeningSessions.equals(_existingListeningSessions)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |listening_sessions(com.safesound.app.data.model.ListeningSessionEntity).
              | Expected:
              |""".trimMargin() + _infoListeningSessions + """
              |
              | Found:
              |""".trimMargin() + _existingListeningSessions)
        }
        val _columnsListeningHistoryCompact: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsListeningHistoryCompact.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningHistoryCompact.put("startTimeMillis", TableInfo.Column("startTimeMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningHistoryCompact.put("endTimeMillis", TableInfo.Column("endTimeMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsListeningHistoryCompact.put("averageVolume", TableInfo.Column("averageVolume", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysListeningHistoryCompact: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesListeningHistoryCompact: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoListeningHistoryCompact: TableInfo = TableInfo("listening_history_compact", _columnsListeningHistoryCompact, _foreignKeysListeningHistoryCompact, _indicesListeningHistoryCompact)
        val _existingListeningHistoryCompact: TableInfo = read(connection, "listening_history_compact")
        if (!_infoListeningHistoryCompact.equals(_existingListeningHistoryCompact)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |listening_history_compact(com.safesound.app.data.model.ListeningHistoryEntity).
              | Expected:
              |""".trimMargin() + _infoListeningHistoryCompact + """
              |
              | Found:
              |""".trimMargin() + _existingListeningHistoryCompact)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "earphone_specs", "bluetooth_devices", "listening_sessions", "listening_history_compact")
  }

  public override fun clearAllTables() {
    super.performClear(false, "earphone_specs", "bluetooth_devices", "listening_sessions", "listening_history_compact")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(EarphoneSpecDao::class, EarphoneSpecDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(BluetoothDeviceDao::class, BluetoothDeviceDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(ListeningSessionDao::class, ListeningSessionDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(HistoryMaintenanceDao::class, HistoryMaintenanceDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>): List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun earphoneSpecDao(): EarphoneSpecDao = _earphoneSpecDao.value

  public override fun deviceDao(): BluetoothDeviceDao = _bluetoothDeviceDao.value

  public override fun listeningSessionDao(): ListeningSessionDao = _listeningSessionDao.value

  public override fun historyMaintenanceDao(): HistoryMaintenanceDao = _historyMaintenanceDao.value
}
