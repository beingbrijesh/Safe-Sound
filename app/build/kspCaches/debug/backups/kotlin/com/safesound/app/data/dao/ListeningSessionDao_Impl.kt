package com.safesound.app.`data`.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.safesound.app.`data`.model.ListeningSessionEntity
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ListeningSessionDao_Impl(
  __db: RoomDatabase,
) : ListeningSessionDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfListeningSessionEntity: EntityInsertAdapter<ListeningSessionEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfListeningSessionEntity = object : EntityInsertAdapter<ListeningSessionEntity>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `listening_sessions` (`id`,`deviceAddress`,`deviceName`,`contentType`,`sourceApp`,`sourcePackage`,`startTimeMillis`,`endTimeMillis`,`averageVolume`,`estimatedDb`,`dosePercent`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ListeningSessionEntity) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.deviceAddress)
        statement.bindText(3, entity.deviceName)
        val _tmpContentType: String? = entity.contentType
        if (_tmpContentType == null) {
          statement.bindNull(4)
        } else {
          statement.bindText(4, _tmpContentType)
        }
        val _tmpSourceApp: String? = entity.sourceApp
        if (_tmpSourceApp == null) {
          statement.bindNull(5)
        } else {
          statement.bindText(5, _tmpSourceApp)
        }
        val _tmpSourcePackage: String? = entity.sourcePackage
        if (_tmpSourcePackage == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpSourcePackage)
        }
        statement.bindLong(7, entity.startTimeMillis)
        statement.bindLong(8, entity.endTimeMillis)
        statement.bindDouble(9, entity.averageVolume)
        statement.bindDouble(10, entity.estimatedDb)
        statement.bindDouble(11, entity.dosePercent)
      }
    }
  }

  public override suspend fun insert(session: ListeningSessionEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfListeningSessionEntity.insert(_connection, session)
  }

  public override fun observeSessions(start: Long, end: Long): Flow<List<ListeningSessionEntity>> {
    val _sql: String = "SELECT * FROM listening_sessions WHERE startTimeMillis BETWEEN ? AND ?"
    return createFlow(__db, false, arrayOf("listening_sessions")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, start)
        _argIndex = 2
        _stmt.bindLong(_argIndex, end)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfDeviceAddress: Int = getColumnIndexOrThrow(_stmt, "deviceAddress")
        val _columnIndexOfDeviceName: Int = getColumnIndexOrThrow(_stmt, "deviceName")
        val _columnIndexOfContentType: Int = getColumnIndexOrThrow(_stmt, "contentType")
        val _columnIndexOfSourceApp: Int = getColumnIndexOrThrow(_stmt, "sourceApp")
        val _columnIndexOfSourcePackage: Int = getColumnIndexOrThrow(_stmt, "sourcePackage")
        val _columnIndexOfStartTimeMillis: Int = getColumnIndexOrThrow(_stmt, "startTimeMillis")
        val _columnIndexOfEndTimeMillis: Int = getColumnIndexOrThrow(_stmt, "endTimeMillis")
        val _columnIndexOfAverageVolume: Int = getColumnIndexOrThrow(_stmt, "averageVolume")
        val _columnIndexOfEstimatedDb: Int = getColumnIndexOrThrow(_stmt, "estimatedDb")
        val _columnIndexOfDosePercent: Int = getColumnIndexOrThrow(_stmt, "dosePercent")
        val _result: MutableList<ListeningSessionEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ListeningSessionEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpDeviceAddress: String
          _tmpDeviceAddress = _stmt.getText(_columnIndexOfDeviceAddress)
          val _tmpDeviceName: String
          _tmpDeviceName = _stmt.getText(_columnIndexOfDeviceName)
          val _tmpContentType: String?
          if (_stmt.isNull(_columnIndexOfContentType)) {
            _tmpContentType = null
          } else {
            _tmpContentType = _stmt.getText(_columnIndexOfContentType)
          }
          val _tmpSourceApp: String?
          if (_stmt.isNull(_columnIndexOfSourceApp)) {
            _tmpSourceApp = null
          } else {
            _tmpSourceApp = _stmt.getText(_columnIndexOfSourceApp)
          }
          val _tmpSourcePackage: String?
          if (_stmt.isNull(_columnIndexOfSourcePackage)) {
            _tmpSourcePackage = null
          } else {
            _tmpSourcePackage = _stmt.getText(_columnIndexOfSourcePackage)
          }
          val _tmpStartTimeMillis: Long
          _tmpStartTimeMillis = _stmt.getLong(_columnIndexOfStartTimeMillis)
          val _tmpEndTimeMillis: Long
          _tmpEndTimeMillis = _stmt.getLong(_columnIndexOfEndTimeMillis)
          val _tmpAverageVolume: Double
          _tmpAverageVolume = _stmt.getDouble(_columnIndexOfAverageVolume)
          val _tmpEstimatedDb: Double
          _tmpEstimatedDb = _stmt.getDouble(_columnIndexOfEstimatedDb)
          val _tmpDosePercent: Double
          _tmpDosePercent = _stmt.getDouble(_columnIndexOfDosePercent)
          _item = ListeningSessionEntity(_tmpId,_tmpDeviceAddress,_tmpDeviceName,_tmpContentType,_tmpSourceApp,_tmpSourcePackage,_tmpStartTimeMillis,_tmpEndTimeMillis,_tmpAverageVolume,_tmpEstimatedDb,_tmpDosePercent)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getSessions(start: Long, end: Long): List<ListeningSessionEntity> {
    val _sql: String = "SELECT * FROM listening_sessions WHERE startTimeMillis BETWEEN ? AND ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, start)
        _argIndex = 2
        _stmt.bindLong(_argIndex, end)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfDeviceAddress: Int = getColumnIndexOrThrow(_stmt, "deviceAddress")
        val _columnIndexOfDeviceName: Int = getColumnIndexOrThrow(_stmt, "deviceName")
        val _columnIndexOfContentType: Int = getColumnIndexOrThrow(_stmt, "contentType")
        val _columnIndexOfSourceApp: Int = getColumnIndexOrThrow(_stmt, "sourceApp")
        val _columnIndexOfSourcePackage: Int = getColumnIndexOrThrow(_stmt, "sourcePackage")
        val _columnIndexOfStartTimeMillis: Int = getColumnIndexOrThrow(_stmt, "startTimeMillis")
        val _columnIndexOfEndTimeMillis: Int = getColumnIndexOrThrow(_stmt, "endTimeMillis")
        val _columnIndexOfAverageVolume: Int = getColumnIndexOrThrow(_stmt, "averageVolume")
        val _columnIndexOfEstimatedDb: Int = getColumnIndexOrThrow(_stmt, "estimatedDb")
        val _columnIndexOfDosePercent: Int = getColumnIndexOrThrow(_stmt, "dosePercent")
        val _result: MutableList<ListeningSessionEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ListeningSessionEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpDeviceAddress: String
          _tmpDeviceAddress = _stmt.getText(_columnIndexOfDeviceAddress)
          val _tmpDeviceName: String
          _tmpDeviceName = _stmt.getText(_columnIndexOfDeviceName)
          val _tmpContentType: String?
          if (_stmt.isNull(_columnIndexOfContentType)) {
            _tmpContentType = null
          } else {
            _tmpContentType = _stmt.getText(_columnIndexOfContentType)
          }
          val _tmpSourceApp: String?
          if (_stmt.isNull(_columnIndexOfSourceApp)) {
            _tmpSourceApp = null
          } else {
            _tmpSourceApp = _stmt.getText(_columnIndexOfSourceApp)
          }
          val _tmpSourcePackage: String?
          if (_stmt.isNull(_columnIndexOfSourcePackage)) {
            _tmpSourcePackage = null
          } else {
            _tmpSourcePackage = _stmt.getText(_columnIndexOfSourcePackage)
          }
          val _tmpStartTimeMillis: Long
          _tmpStartTimeMillis = _stmt.getLong(_columnIndexOfStartTimeMillis)
          val _tmpEndTimeMillis: Long
          _tmpEndTimeMillis = _stmt.getLong(_columnIndexOfEndTimeMillis)
          val _tmpAverageVolume: Double
          _tmpAverageVolume = _stmt.getDouble(_columnIndexOfAverageVolume)
          val _tmpEstimatedDb: Double
          _tmpEstimatedDb = _stmt.getDouble(_columnIndexOfEstimatedDb)
          val _tmpDosePercent: Double
          _tmpDosePercent = _stmt.getDouble(_columnIndexOfDosePercent)
          _item = ListeningSessionEntity(_tmpId,_tmpDeviceAddress,_tmpDeviceName,_tmpContentType,_tmpSourceApp,_tmpSourcePackage,_tmpStartTimeMillis,_tmpEndTimeMillis,_tmpAverageVolume,_tmpEstimatedDb,_tmpDosePercent)
          _result.add(_item)
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
