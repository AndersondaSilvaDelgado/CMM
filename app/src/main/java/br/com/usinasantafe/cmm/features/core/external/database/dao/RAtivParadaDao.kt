package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.RAtivParadaModel

@Dao
interface RAtivParadaDao {

    @Insert
    suspend fun insert(rAtivParadaModel: RAtivParadaModel): Long

    @Query("DELETE FROM tbrativparadaest")
    suspend fun deleteAll()

}