package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ServicoModel

@Dao
interface ServicoDao {

    @Insert
    suspend fun insertAll(vararg servicoModels: ServicoModel)

    @Query("DELETE FROM tbservicoest")
    suspend fun deleteAll()
}