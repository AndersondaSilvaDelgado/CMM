package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.REquipPneuModel

@Dao
interface REquipPneuDao {

    @Insert
    suspend fun insert(rEquipPneuModel: REquipPneuModel): Long

    @Query("DELETE FROM tbrequippneuest")
    suspend fun deleteAll()

}