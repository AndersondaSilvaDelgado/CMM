package br.com.usinasantafe.cmm.features.external.room.dao.stable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.common.utils.TB_PRODUTO
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ProdutoRoomModel

@Dao
interface ProdutoDao {

    @Insert
    suspend fun insertAll(vararg produtoRoomModels: ProdutoRoomModel)

    @Query("DELETE FROM $TB_PRODUTO")
    suspend fun deleteAll()

}