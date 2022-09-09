package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.ParadaModel

@Dao
interface ParadaDao {

    @Insert
    suspend fun insert(paradaModel: ParadaModel): Long

    @Query("DELETE FROM tbparadaest")
    suspend fun deleteAll()

}