package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.ServicoModel

@Dao
interface ServicoDao {

    @Insert
    suspend fun insert(servicoModel: ServicoModel): Long

    @Query("DELETE FROM tbservicoest")
    suspend fun deleteAll()
}