package com.safesound.app.`data`.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.safesound.app.`data`.model.EarphoneSpecEntity
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Double
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
public class EarphoneSpecDao_Impl(
  __db: RoomDatabase,
) : EarphoneSpecDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfEarphoneSpecEntity: EntityInsertAdapter<EarphoneSpecEntity>

  private val __updateAdapterOfEarphoneSpecEntity: EntityDeleteOrUpdateAdapter<EarphoneSpecEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfEarphoneSpecEntity = object : EntityInsertAdapter<EarphoneSpecEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `earphone_specs` (`id`,`brand`,`model`,`displayName`,`driverSizeMm`,`frequencyLowHz`,`frequencyHighHz`,`impedanceOhm`,`sensitivityDb`,`powerMw`,`sourceName`,`sourceUrl`,`verified`,`lastFetchedMillis`,`calibrationOffsetDb`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: EarphoneSpecEntity) {
        statement.bindLong(1, entity.id)
        val _tmpBrand: String? = entity.brand
        if (_tmpBrand == null) {
          statement.bindNull(2)
        } else {
          statement.bindText(2, _tmpBrand)
        }
        val _tmpModel: String? = entity.model
        if (_tmpModel == null) {
          statement.bindNull(3)
        } else {
          statement.bindText(3, _tmpModel)
        }
        statement.bindText(4, entity.displayName)
        val _tmpDriverSizeMm: Double? = entity.driverSizeMm
        if (_tmpDriverSizeMm == null) {
          statement.bindNull(5)
        } else {
          statement.bindDouble(5, _tmpDriverSizeMm)
        }
        val _tmpFrequencyLowHz: Int? = entity.frequencyLowHz
        if (_tmpFrequencyLowHz == null) {
          statement.bindNull(6)
        } else {
          statement.bindLong(6, _tmpFrequencyLowHz.toLong())
        }
        val _tmpFrequencyHighHz: Int? = entity.frequencyHighHz
        if (_tmpFrequencyHighHz == null) {
          statement.bindNull(7)
        } else {
          statement.bindLong(7, _tmpFrequencyHighHz.toLong())
        }
        val _tmpImpedanceOhm: Double? = entity.impedanceOhm
        if (_tmpImpedanceOhm == null) {
          statement.bindNull(8)
        } else {
          statement.bindDouble(8, _tmpImpedanceOhm)
        }
        val _tmpSensitivityDb: Double? = entity.sensitivityDb
        if (_tmpSensitivityDb == null) {
          statement.bindNull(9)
        } else {
          statement.bindDouble(9, _tmpSensitivityDb)
        }
        val _tmpPowerMw: Double? = entity.powerMw
        if (_tmpPowerMw == null) {
          statement.bindNull(10)
        } else {
          statement.bindDouble(10, _tmpPowerMw)
        }
        val _tmpSourceName: String? = entity.sourceName
        if (_tmpSourceName == null) {
          statement.bindNull(11)
        } else {
          statement.bindText(11, _tmpSourceName)
        }
        val _tmpSourceUrl: String? = entity.sourceUrl
        if (_tmpSourceUrl == null) {
          statement.bindNull(12)
        } else {
          statement.bindText(12, _tmpSourceUrl)
        }
        val _tmp: Int = if (entity.verified) 1 else 0
        statement.bindLong(13, _tmp.toLong())
        statement.bindLong(14, entity.lastFetchedMillis)
        val _tmpCalibrationOffsetDb: Double? = entity.calibrationOffsetDb
        if (_tmpCalibrationOffsetDb == null) {
          statement.bindNull(15)
        } else {
          statement.bindDouble(15, _tmpCalibrationOffsetDb)
        }
      }
    }
    this.__updateAdapterOfEarphoneSpecEntity = object : EntityDeleteOrUpdateAdapter<EarphoneSpecEntity>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `earphone_specs` SET `id` = ?,`brand` = ?,`model` = ?,`displayName` = ?,`driverSizeMm` = ?,`frequencyLowHz` = ?,`frequencyHighHz` = ?,`impedanceOhm` = ?,`sensitivityDb` = ?,`powerMw` = ?,`sourceName` = ?,`sourceUrl` = ?,`verified` = ?,`lastFetchedMillis` = ?,`calibrationOffsetDb` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: EarphoneSpecEntity) {
        statement.bindLong(1, entity.id)
        val _tmpBrand: String? = entity.brand
        if (_tmpBrand == null) {
          statement.bindNull(2)
        } else {
          statement.bindText(2, _tmpBrand)
        }
        val _tmpModel: String? = entity.model
        if (_tmpModel == null) {
          statement.bindNull(3)
        } else {
          statement.bindText(3, _tmpModel)
        }
        statement.bindText(4, entity.displayName)
        val _tmpDriverSizeMm: Double? = entity.driverSizeMm
        if (_tmpDriverSizeMm == null) {
          statement.bindNull(5)
        } else {
          statement.bindDouble(5, _tmpDriverSizeMm)
        }
        val _tmpFrequencyLowHz: Int? = entity.frequencyLowHz
        if (_tmpFrequencyLowHz == null) {
          statement.bindNull(6)
        } else {
          statement.bindLong(6, _tmpFrequencyLowHz.toLong())
        }
        val _tmpFrequencyHighHz: Int? = entity.frequencyHighHz
        if (_tmpFrequencyHighHz == null) {
          statement.bindNull(7)
        } else {
          statement.bindLong(7, _tmpFrequencyHighHz.toLong())
        }
        val _tmpImpedanceOhm: Double? = entity.impedanceOhm
        if (_tmpImpedanceOhm == null) {
          statement.bindNull(8)
        } else {
          statement.bindDouble(8, _tmpImpedanceOhm)
        }
        val _tmpSensitivityDb: Double? = entity.sensitivityDb
        if (_tmpSensitivityDb == null) {
          statement.bindNull(9)
        } else {
          statement.bindDouble(9, _tmpSensitivityDb)
        }
        val _tmpPowerMw: Double? = entity.powerMw
        if (_tmpPowerMw == null) {
          statement.bindNull(10)
        } else {
          statement.bindDouble(10, _tmpPowerMw)
        }
        val _tmpSourceName: String? = entity.sourceName
        if (_tmpSourceName == null) {
          statement.bindNull(11)
        } else {
          statement.bindText(11, _tmpSourceName)
        }
        val _tmpSourceUrl: String? = entity.sourceUrl
        if (_tmpSourceUrl == null) {
          statement.bindNull(12)
        } else {
          statement.bindText(12, _tmpSourceUrl)
        }
        val _tmp: Int = if (entity.verified) 1 else 0
        statement.bindLong(13, _tmp.toLong())
        statement.bindLong(14, entity.lastFetchedMillis)
        val _tmpCalibrationOffsetDb: Double? = entity.calibrationOffsetDb
        if (_tmpCalibrationOffsetDb == null) {
          statement.bindNull(15)
        } else {
          statement.bindDouble(15, _tmpCalibrationOffsetDb)
        }
        statement.bindLong(16, entity.id)
      }
    }
  }

  public override suspend fun insert(spec: EarphoneSpecEntity): Long = performSuspending(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfEarphoneSpecEntity.insertAndReturnId(_connection, spec)
    _result
  }

  public override suspend fun update(spec: EarphoneSpecEntity): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfEarphoneSpecEntity.handle(_connection, spec)
  }

  public override suspend fun getById(id: Long): EarphoneSpecEntity? {
    val _sql: String = "SELECT * FROM earphone_specs WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfBrand: Int = getColumnIndexOrThrow(_stmt, "brand")
        val _columnIndexOfModel: Int = getColumnIndexOrThrow(_stmt, "model")
        val _columnIndexOfDisplayName: Int = getColumnIndexOrThrow(_stmt, "displayName")
        val _columnIndexOfDriverSizeMm: Int = getColumnIndexOrThrow(_stmt, "driverSizeMm")
        val _columnIndexOfFrequencyLowHz: Int = getColumnIndexOrThrow(_stmt, "frequencyLowHz")
        val _columnIndexOfFrequencyHighHz: Int = getColumnIndexOrThrow(_stmt, "frequencyHighHz")
        val _columnIndexOfImpedanceOhm: Int = getColumnIndexOrThrow(_stmt, "impedanceOhm")
        val _columnIndexOfSensitivityDb: Int = getColumnIndexOrThrow(_stmt, "sensitivityDb")
        val _columnIndexOfPowerMw: Int = getColumnIndexOrThrow(_stmt, "powerMw")
        val _columnIndexOfSourceName: Int = getColumnIndexOrThrow(_stmt, "sourceName")
        val _columnIndexOfSourceUrl: Int = getColumnIndexOrThrow(_stmt, "sourceUrl")
        val _columnIndexOfVerified: Int = getColumnIndexOrThrow(_stmt, "verified")
        val _columnIndexOfLastFetchedMillis: Int = getColumnIndexOrThrow(_stmt, "lastFetchedMillis")
        val _columnIndexOfCalibrationOffsetDb: Int = getColumnIndexOrThrow(_stmt, "calibrationOffsetDb")
        val _result: EarphoneSpecEntity?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpBrand: String?
          if (_stmt.isNull(_columnIndexOfBrand)) {
            _tmpBrand = null
          } else {
            _tmpBrand = _stmt.getText(_columnIndexOfBrand)
          }
          val _tmpModel: String?
          if (_stmt.isNull(_columnIndexOfModel)) {
            _tmpModel = null
          } else {
            _tmpModel = _stmt.getText(_columnIndexOfModel)
          }
          val _tmpDisplayName: String
          _tmpDisplayName = _stmt.getText(_columnIndexOfDisplayName)
          val _tmpDriverSizeMm: Double?
          if (_stmt.isNull(_columnIndexOfDriverSizeMm)) {
            _tmpDriverSizeMm = null
          } else {
            _tmpDriverSizeMm = _stmt.getDouble(_columnIndexOfDriverSizeMm)
          }
          val _tmpFrequencyLowHz: Int?
          if (_stmt.isNull(_columnIndexOfFrequencyLowHz)) {
            _tmpFrequencyLowHz = null
          } else {
            _tmpFrequencyLowHz = _stmt.getLong(_columnIndexOfFrequencyLowHz).toInt()
          }
          val _tmpFrequencyHighHz: Int?
          if (_stmt.isNull(_columnIndexOfFrequencyHighHz)) {
            _tmpFrequencyHighHz = null
          } else {
            _tmpFrequencyHighHz = _stmt.getLong(_columnIndexOfFrequencyHighHz).toInt()
          }
          val _tmpImpedanceOhm: Double?
          if (_stmt.isNull(_columnIndexOfImpedanceOhm)) {
            _tmpImpedanceOhm = null
          } else {
            _tmpImpedanceOhm = _stmt.getDouble(_columnIndexOfImpedanceOhm)
          }
          val _tmpSensitivityDb: Double?
          if (_stmt.isNull(_columnIndexOfSensitivityDb)) {
            _tmpSensitivityDb = null
          } else {
            _tmpSensitivityDb = _stmt.getDouble(_columnIndexOfSensitivityDb)
          }
          val _tmpPowerMw: Double?
          if (_stmt.isNull(_columnIndexOfPowerMw)) {
            _tmpPowerMw = null
          } else {
            _tmpPowerMw = _stmt.getDouble(_columnIndexOfPowerMw)
          }
          val _tmpSourceName: String?
          if (_stmt.isNull(_columnIndexOfSourceName)) {
            _tmpSourceName = null
          } else {
            _tmpSourceName = _stmt.getText(_columnIndexOfSourceName)
          }
          val _tmpSourceUrl: String?
          if (_stmt.isNull(_columnIndexOfSourceUrl)) {
            _tmpSourceUrl = null
          } else {
            _tmpSourceUrl = _stmt.getText(_columnIndexOfSourceUrl)
          }
          val _tmpVerified: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfVerified).toInt()
          _tmpVerified = _tmp != 0
          val _tmpLastFetchedMillis: Long
          _tmpLastFetchedMillis = _stmt.getLong(_columnIndexOfLastFetchedMillis)
          val _tmpCalibrationOffsetDb: Double?
          if (_stmt.isNull(_columnIndexOfCalibrationOffsetDb)) {
            _tmpCalibrationOffsetDb = null
          } else {
            _tmpCalibrationOffsetDb = _stmt.getDouble(_columnIndexOfCalibrationOffsetDb)
          }
          _result = EarphoneSpecEntity(_tmpId,_tmpBrand,_tmpModel,_tmpDisplayName,_tmpDriverSizeMm,_tmpFrequencyLowHz,_tmpFrequencyHighHz,_tmpImpedanceOhm,_tmpSensitivityDb,_tmpPowerMw,_tmpSourceName,_tmpSourceUrl,_tmpVerified,_tmpLastFetchedMillis,_tmpCalibrationOffsetDb)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun findByDisplayName(name: String): EarphoneSpecEntity? {
    val _sql: String = "SELECT * FROM earphone_specs WHERE displayName = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, name)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfBrand: Int = getColumnIndexOrThrow(_stmt, "brand")
        val _columnIndexOfModel: Int = getColumnIndexOrThrow(_stmt, "model")
        val _columnIndexOfDisplayName: Int = getColumnIndexOrThrow(_stmt, "displayName")
        val _columnIndexOfDriverSizeMm: Int = getColumnIndexOrThrow(_stmt, "driverSizeMm")
        val _columnIndexOfFrequencyLowHz: Int = getColumnIndexOrThrow(_stmt, "frequencyLowHz")
        val _columnIndexOfFrequencyHighHz: Int = getColumnIndexOrThrow(_stmt, "frequencyHighHz")
        val _columnIndexOfImpedanceOhm: Int = getColumnIndexOrThrow(_stmt, "impedanceOhm")
        val _columnIndexOfSensitivityDb: Int = getColumnIndexOrThrow(_stmt, "sensitivityDb")
        val _columnIndexOfPowerMw: Int = getColumnIndexOrThrow(_stmt, "powerMw")
        val _columnIndexOfSourceName: Int = getColumnIndexOrThrow(_stmt, "sourceName")
        val _columnIndexOfSourceUrl: Int = getColumnIndexOrThrow(_stmt, "sourceUrl")
        val _columnIndexOfVerified: Int = getColumnIndexOrThrow(_stmt, "verified")
        val _columnIndexOfLastFetchedMillis: Int = getColumnIndexOrThrow(_stmt, "lastFetchedMillis")
        val _columnIndexOfCalibrationOffsetDb: Int = getColumnIndexOrThrow(_stmt, "calibrationOffsetDb")
        val _result: EarphoneSpecEntity?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpBrand: String?
          if (_stmt.isNull(_columnIndexOfBrand)) {
            _tmpBrand = null
          } else {
            _tmpBrand = _stmt.getText(_columnIndexOfBrand)
          }
          val _tmpModel: String?
          if (_stmt.isNull(_columnIndexOfModel)) {
            _tmpModel = null
          } else {
            _tmpModel = _stmt.getText(_columnIndexOfModel)
          }
          val _tmpDisplayName: String
          _tmpDisplayName = _stmt.getText(_columnIndexOfDisplayName)
          val _tmpDriverSizeMm: Double?
          if (_stmt.isNull(_columnIndexOfDriverSizeMm)) {
            _tmpDriverSizeMm = null
          } else {
            _tmpDriverSizeMm = _stmt.getDouble(_columnIndexOfDriverSizeMm)
          }
          val _tmpFrequencyLowHz: Int?
          if (_stmt.isNull(_columnIndexOfFrequencyLowHz)) {
            _tmpFrequencyLowHz = null
          } else {
            _tmpFrequencyLowHz = _stmt.getLong(_columnIndexOfFrequencyLowHz).toInt()
          }
          val _tmpFrequencyHighHz: Int?
          if (_stmt.isNull(_columnIndexOfFrequencyHighHz)) {
            _tmpFrequencyHighHz = null
          } else {
            _tmpFrequencyHighHz = _stmt.getLong(_columnIndexOfFrequencyHighHz).toInt()
          }
          val _tmpImpedanceOhm: Double?
          if (_stmt.isNull(_columnIndexOfImpedanceOhm)) {
            _tmpImpedanceOhm = null
          } else {
            _tmpImpedanceOhm = _stmt.getDouble(_columnIndexOfImpedanceOhm)
          }
          val _tmpSensitivityDb: Double?
          if (_stmt.isNull(_columnIndexOfSensitivityDb)) {
            _tmpSensitivityDb = null
          } else {
            _tmpSensitivityDb = _stmt.getDouble(_columnIndexOfSensitivityDb)
          }
          val _tmpPowerMw: Double?
          if (_stmt.isNull(_columnIndexOfPowerMw)) {
            _tmpPowerMw = null
          } else {
            _tmpPowerMw = _stmt.getDouble(_columnIndexOfPowerMw)
          }
          val _tmpSourceName: String?
          if (_stmt.isNull(_columnIndexOfSourceName)) {
            _tmpSourceName = null
          } else {
            _tmpSourceName = _stmt.getText(_columnIndexOfSourceName)
          }
          val _tmpSourceUrl: String?
          if (_stmt.isNull(_columnIndexOfSourceUrl)) {
            _tmpSourceUrl = null
          } else {
            _tmpSourceUrl = _stmt.getText(_columnIndexOfSourceUrl)
          }
          val _tmpVerified: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfVerified).toInt()
          _tmpVerified = _tmp != 0
          val _tmpLastFetchedMillis: Long
          _tmpLastFetchedMillis = _stmt.getLong(_columnIndexOfLastFetchedMillis)
          val _tmpCalibrationOffsetDb: Double?
          if (_stmt.isNull(_columnIndexOfCalibrationOffsetDb)) {
            _tmpCalibrationOffsetDb = null
          } else {
            _tmpCalibrationOffsetDb = _stmt.getDouble(_columnIndexOfCalibrationOffsetDb)
          }
          _result = EarphoneSpecEntity(_tmpId,_tmpBrand,_tmpModel,_tmpDisplayName,_tmpDriverSizeMm,_tmpFrequencyLowHz,_tmpFrequencyHighHz,_tmpImpedanceOhm,_tmpSensitivityDb,_tmpPowerMw,_tmpSourceName,_tmpSourceUrl,_tmpVerified,_tmpLastFetchedMillis,_tmpCalibrationOffsetDb)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun observeById(id: Long): Flow<EarphoneSpecEntity?> {
    val _sql: String = "SELECT * FROM earphone_specs WHERE id = ?"
    return createFlow(__db, false, arrayOf("earphone_specs")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfBrand: Int = getColumnIndexOrThrow(_stmt, "brand")
        val _columnIndexOfModel: Int = getColumnIndexOrThrow(_stmt, "model")
        val _columnIndexOfDisplayName: Int = getColumnIndexOrThrow(_stmt, "displayName")
        val _columnIndexOfDriverSizeMm: Int = getColumnIndexOrThrow(_stmt, "driverSizeMm")
        val _columnIndexOfFrequencyLowHz: Int = getColumnIndexOrThrow(_stmt, "frequencyLowHz")
        val _columnIndexOfFrequencyHighHz: Int = getColumnIndexOrThrow(_stmt, "frequencyHighHz")
        val _columnIndexOfImpedanceOhm: Int = getColumnIndexOrThrow(_stmt, "impedanceOhm")
        val _columnIndexOfSensitivityDb: Int = getColumnIndexOrThrow(_stmt, "sensitivityDb")
        val _columnIndexOfPowerMw: Int = getColumnIndexOrThrow(_stmt, "powerMw")
        val _columnIndexOfSourceName: Int = getColumnIndexOrThrow(_stmt, "sourceName")
        val _columnIndexOfSourceUrl: Int = getColumnIndexOrThrow(_stmt, "sourceUrl")
        val _columnIndexOfVerified: Int = getColumnIndexOrThrow(_stmt, "verified")
        val _columnIndexOfLastFetchedMillis: Int = getColumnIndexOrThrow(_stmt, "lastFetchedMillis")
        val _columnIndexOfCalibrationOffsetDb: Int = getColumnIndexOrThrow(_stmt, "calibrationOffsetDb")
        val _result: EarphoneSpecEntity?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpBrand: String?
          if (_stmt.isNull(_columnIndexOfBrand)) {
            _tmpBrand = null
          } else {
            _tmpBrand = _stmt.getText(_columnIndexOfBrand)
          }
          val _tmpModel: String?
          if (_stmt.isNull(_columnIndexOfModel)) {
            _tmpModel = null
          } else {
            _tmpModel = _stmt.getText(_columnIndexOfModel)
          }
          val _tmpDisplayName: String
          _tmpDisplayName = _stmt.getText(_columnIndexOfDisplayName)
          val _tmpDriverSizeMm: Double?
          if (_stmt.isNull(_columnIndexOfDriverSizeMm)) {
            _tmpDriverSizeMm = null
          } else {
            _tmpDriverSizeMm = _stmt.getDouble(_columnIndexOfDriverSizeMm)
          }
          val _tmpFrequencyLowHz: Int?
          if (_stmt.isNull(_columnIndexOfFrequencyLowHz)) {
            _tmpFrequencyLowHz = null
          } else {
            _tmpFrequencyLowHz = _stmt.getLong(_columnIndexOfFrequencyLowHz).toInt()
          }
          val _tmpFrequencyHighHz: Int?
          if (_stmt.isNull(_columnIndexOfFrequencyHighHz)) {
            _tmpFrequencyHighHz = null
          } else {
            _tmpFrequencyHighHz = _stmt.getLong(_columnIndexOfFrequencyHighHz).toInt()
          }
          val _tmpImpedanceOhm: Double?
          if (_stmt.isNull(_columnIndexOfImpedanceOhm)) {
            _tmpImpedanceOhm = null
          } else {
            _tmpImpedanceOhm = _stmt.getDouble(_columnIndexOfImpedanceOhm)
          }
          val _tmpSensitivityDb: Double?
          if (_stmt.isNull(_columnIndexOfSensitivityDb)) {
            _tmpSensitivityDb = null
          } else {
            _tmpSensitivityDb = _stmt.getDouble(_columnIndexOfSensitivityDb)
          }
          val _tmpPowerMw: Double?
          if (_stmt.isNull(_columnIndexOfPowerMw)) {
            _tmpPowerMw = null
          } else {
            _tmpPowerMw = _stmt.getDouble(_columnIndexOfPowerMw)
          }
          val _tmpSourceName: String?
          if (_stmt.isNull(_columnIndexOfSourceName)) {
            _tmpSourceName = null
          } else {
            _tmpSourceName = _stmt.getText(_columnIndexOfSourceName)
          }
          val _tmpSourceUrl: String?
          if (_stmt.isNull(_columnIndexOfSourceUrl)) {
            _tmpSourceUrl = null
          } else {
            _tmpSourceUrl = _stmt.getText(_columnIndexOfSourceUrl)
          }
          val _tmpVerified: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfVerified).toInt()
          _tmpVerified = _tmp != 0
          val _tmpLastFetchedMillis: Long
          _tmpLastFetchedMillis = _stmt.getLong(_columnIndexOfLastFetchedMillis)
          val _tmpCalibrationOffsetDb: Double?
          if (_stmt.isNull(_columnIndexOfCalibrationOffsetDb)) {
            _tmpCalibrationOffsetDb = null
          } else {
            _tmpCalibrationOffsetDb = _stmt.getDouble(_columnIndexOfCalibrationOffsetDb)
          }
          _result = EarphoneSpecEntity(_tmpId,_tmpBrand,_tmpModel,_tmpDisplayName,_tmpDriverSizeMm,_tmpFrequencyLowHz,_tmpFrequencyHighHz,_tmpImpedanceOhm,_tmpSensitivityDb,_tmpPowerMw,_tmpSourceName,_tmpSourceUrl,_tmpVerified,_tmpLastFetchedMillis,_tmpCalibrationOffsetDb)
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
