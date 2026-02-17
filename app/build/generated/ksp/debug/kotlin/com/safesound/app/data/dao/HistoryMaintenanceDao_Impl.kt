package com.safesound.app.`data`.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.getTotalChangedRows
import androidx.room.util.performInTransactionSuspending
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.safesound.app.`data`.model.ListeningHistoryEntity
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

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class HistoryMaintenanceDao_Impl(
  __db: RoomDatabase,
) : HistoryMaintenanceDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfListeningHistoryEntity: EntityInsertAdapter<ListeningHistoryEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfListeningHistoryEntity = object : EntityInsertAdapter<ListeningHistoryEntity>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `listening_history_compact` (`id`,`startTimeMillis`,`endTimeMillis`,`averageVolume`) VALUES (nullif(?, 0),?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ListeningHistoryEntity) {
        statement.bindLong(1, entity.id)
        statement.bindLong(2, entity.startTimeMillis)
        statement.bindLong(3, entity.endTimeMillis)
        statement.bindDouble(4, entity.averageVolume)
      }
    }
  }

  public override suspend fun insertHistory(entries: List<ListeningHistoryEntity>): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfListeningHistoryEntity.insert(_connection, entries)
  }

  public override suspend fun compactOldSessions(cutoff: Long): Int = performInTransactionSuspending(__db) {
    super@HistoryMaintenanceDao_Impl.compactOldSessions(cutoff)
  }

  public override suspend fun getSessionsBefore(cutoff: Long): List<ListeningSessionEntity> {
    val _sql: String = "SELECT * FROM listening_sessions WHERE startTimeMillis < ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, cutoff)
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

  public override suspend fun deleteSessionsBefore(cutoff: Long): Int {
    val _sql: String = "DELETE FROM listening_sessions WHERE startTimeMillis < ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, cutoff)
        _stmt.step()
        getTotalChangedRows(_connection)
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
