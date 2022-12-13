package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_SERVICO
import br.com.usinasantafe.cmm.features.infra.models.stable.ServicoModel

@Dao
interface ServicoDao {

    @Insert
    suspend fun insertAll(vararg servicoModels: ServicoModel)

    @Query("DELETE FROM $TB_SERVICO")
    suspend fun deleteAll()
}