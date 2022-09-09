package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.RFuncaoAtivParadaModel

@Dao
interface RFuncaoAtivParadaDao {

    @Insert
    suspend fun insert(rFuncaoAtivParadaModel: RFuncaoAtivParadaModel): Long

    @Query("DELETE FROM tbrfuncaoativparadaest")
    suspend fun deleteAll()

}