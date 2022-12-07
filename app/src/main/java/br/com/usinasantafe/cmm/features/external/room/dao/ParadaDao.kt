package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ParadaModel

@Dao
interface ParadaDao {

    @Insert
    suspend fun insertAll(vararg paradaModels: ParadaModel)

    @Query("DELETE FROM tbparadaest")
    suspend fun deleteAll()

}