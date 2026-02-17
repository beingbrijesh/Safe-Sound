package com.safesound.app.`data`.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.safesound.app.`data`.model.BluetoothDeviceEntity
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class BluetoothDeviceDao_Impl(
  __db: RoomDatabase,
) : BluetoothDeviceDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfBluetoothDeviceEntity: EntityInsertAdapter<BluetoothDeviceEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfBluetoothDeviceEntity = object : EntityInsertAdapter<BluetoothDeviceEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `bluetooth_devices` (`address`,`name`,`lastSeenMillis`,`isConnected`,`specId`) VALUES (?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: BluetoothDeviceEntity) {
        statement.bindText(1, entity.address)
        val _tmpName: String? = entity.name
        if (_tmpName == null) {
          statement.bindNull(2)
        } else {
          statement.bindText(2, _tmpName)
        }
        statement.bindLong(3, entity.lastSeenMillis)
        val _tmp: Int = if (entity.isConnected) 1 else 0
        statement.bindLong(4, _tmp.toLong())
        val _tmpSpecId: Long? = entity.specId
        if (_tmpSpecId == null) {
          statement.bindNull(5)
        } else {
          statement.bindLong(5, _tmpSpecId)
        }
      }
    }
  }

  public override suspend fun upsert(device: BluetoothDeviceEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfBluetoothDeviceEntity.insert(_connection, device)
  }

  public override suspend fun `get`(address: String): BluetoothDeviceEntity? {
    val _sql: String = "SELECT * FROM bluetooth_devices WHERE address = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, address)
        val _columnIndexOfAddress: Int = getColumnIndexOrThrow(_stmt, "address")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfLastSeenMillis: Int = getColumnIndexOrThrow(_stmt, "lastSeenMillis")
        val _columnIndexOfIsConnected: Int = getColumnIndexOrThrow(_stmt, "isConnected")
        val _columnIndexOfSpecId: Int = getColumnIndexOrThrow(_stmt, "specId")
        val _result: BluetoothDeviceEntity?
        if (_stmt.step()) {
          val _tmpAddress: String
          _tmpAddress = _stmt.getText(_columnIndexOfAddress)
          val _tmpName: String?
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName)
          }
          val _tmpLastSeenMillis: Long
          _tmpLastSeenMillis = _stmt.getLong(_columnIndexOfLastSeenMillis)
          val _tmpIsConnected: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsConnected).toInt()
          _tmpIsConnected = _tmp != 0
          val _tmpSpecId: Long?
          if (_stmt.isNull(_columnIndexOfSpecId)) {
            _tmpSpecId = null
          } else {
            _tmpSpecId = _stmt.getLong(_columnIndexOfSpecId)
          }
          _result = BluetoothDeviceEntity(_tmpAddress,_tmpName,_tmpLastSeenMillis,_tmpIsConnected,_tmpSpecId)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun observeDevice(address: String): Flow<BluetoothDeviceEntity?> {
    val _sql: String = "SELECT * FROM bluetooth_devices WHERE address = ?"
    return createFlow(__db, false, arrayOf("bluetooth_devices")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, address)
        val _columnIndexOfAddress: Int = getColumnIndexOrThrow(_stmt, "address")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfLastSeenMillis: Int = getColumnIndexOrThrow(_stmt, "lastSeenMillis")
        val _columnIndexOfIsConnected: Int = getColumnIndexOrThrow(_stmt, "isConnected")
        val _columnIndexOfSpecId: Int = getColumnIndexOrThrow(_stmt, "specId")
        val _result: BluetoothDeviceEntity?
        if (_stmt.step()) {
          val _tmpAddress: String
          _tmpAddress = _stmt.getText(_columnIndexOfAddress)
          val _tmpName: String?
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName)
          }
          val _tmpLastSeenMillis: Long
          _tmpLastSeenMillis = _stmt.getLong(_columnIndexOfLastSeenMillis)
          val _tmpIsConnected: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsConnected).toInt()
          _tmpIsConnected = _tmp != 0
          val _tmpSpecId: Long?
          if (_stmt.isNull(_columnIndexOfSpecId)) {
            _tmpSpecId = null
          } else {
            _tmpSpecId = _stmt.getLong(_columnIndexOfSpecId)
          }
          _result = BluetoothDeviceEntity(_tmpAddress,_tmpName,_tmpLastSeenMillis,_tmpIsConnected,_tmpSpecId)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun observeConnectedDevice(): Flow<BluetoothDeviceEntity?> {
    val _sql: String = "SELECT * FROM bluetooth_devices WHERE isConnected = 1 ORDER BY lastSeenMillis DESC LIMIT 1"
    return createFlow(__db, false, arrayOf("bluetooth_devices")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfAddress: Int = getColumnIndexOrThrow(_stmt, "address")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfLastSeenMillis: Int = getColumnIndexOrThrow(_stmt, "lastSeenMillis")
        val _columnIndexOfIsConnected: Int = getColumnIndexOrThrow(_stmt, "isConnected")
        val _columnIndexOfSpecId: Int = getColumnIndexOrThrow(_stmt, "specId")
        val _result: BluetoothDeviceEntity?
        if (_stmt.step()) {
          val _tmpAddress: String
          _tmpAddress = _stmt.getText(_columnIndexOfAddress)
          val _tmpName: String?
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName)
          }
          val _tmpLastSeenMillis: Long
          _tmpLastSeenMillis = _stmt.getLong(_columnIndexOfLastSeenMillis)
          val _tmpIsConnected: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsConnected).toInt()
          _tmpIsConnected = _tmp != 0
          val _tmpSpecId: Long?
          if (_stmt.isNull(_columnIndexOfSpecId)) {
            _tmpSpecId = null
          } else {
            _tmpSpecId = _stmt.getLong(_columnIndexOfSpecId)
          }
          _result = BluetoothDeviceEntity(_tmpAddress,_tmpName,_tmpLastSeenMillis,_tmpIsConnected,_tmpSpecId)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun observeMostRecentDevice(): Flow<BluetoothDeviceEntity?> {
    val _sql: String = "SELECT * FROM bluetooth_devices ORDER BY lastSeenMillis DESC LIMIT 1"
    return createFlow(__db, false, arrayOf("bluetooth_devices")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfAddress: Int = getColumnIndexOrThrow(_stmt, "address")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfLastSeenMillis: Int = getColumnIndexOrThrow(_stmt, "lastSeenMillis")
        val _columnIndexOfIsConnected: Int = getColumnIndexOrThrow(_stmt, "isConnected")
        val _columnIndexOfSpecId: Int = getColumnIndexOrThrow(_stmt, "specId")
        val _result: BluetoothDeviceEntity?
        if (_stmt.step()) {
          val _tmpAddress: String
          _tmpAddress = _stmt.getText(_columnIndexOfAddress)
          val _tmpName: String?
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName)
          }
          val _tmpLastSeenMillis: Long
          _tmpLastSeenMillis = _stmt.getLong(_columnIndexOfLastSeenMillis)
          val _tmpIsConnected: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsConnected).toInt()
          _tmpIsConnected = _tmp != 0
          val _tmpSpecId: Long?
          if (_stmt.isNull(_columnIndexOfSpecId)) {
            _tmpSpecId = null
          } else {
            _tmpSpecId = _stmt.getLong(_columnIndexOfSpecId)
          }
          _result = BluetoothDeviceEntity(_tmpAddress,_tmpName,_tmpLastSeenMillis,_tmpIsConnected,_tmpSpecId)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
