package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.REquipPneuModel

@Dao
interface REquipPneuDao {

    @Insert
    suspend fun insertAll(vararg rEquipPneuModels: REquipPneuModel)

    @Query("DELETE FROM tbrequippneuest")
    suspend fun deleteAll()

}