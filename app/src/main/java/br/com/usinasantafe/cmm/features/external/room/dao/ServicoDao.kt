package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ServicoModel

@Dao
interface ServicoDao {

    @Insert
    suspend fun insert(servicoModel: ServicoModel): Long

    @Query("DELETE FROM tbservicoest")
    suspend fun deleteAll()
}