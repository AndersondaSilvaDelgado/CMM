package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_SERVICO
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ServicoRoomModel

@Dao
interface ServicoDao {

    @Insert
    suspend fun insertAll(vararg servicoRoomModels: ServicoRoomModel)

    @Query("DELETE FROM $TB_SERVICO")
    suspend fun deleteAll()
}