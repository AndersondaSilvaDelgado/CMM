package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.RAtivParadaModel

@Dao
interface RAtivParadaDao {

    @Insert
    suspend fun insertAll(vararg rAtivParadaModels: RAtivParadaModel)

    @Query("DELETE FROM tbrativparadaest")
    suspend fun deleteAll()

}