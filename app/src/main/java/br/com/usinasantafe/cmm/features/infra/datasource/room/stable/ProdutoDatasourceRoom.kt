package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ProdutoRoomModel

interface ProdutoDatasourceRoom {

    suspend fun addAllProduto(vararg produtoRoomModels: ProdutoRoomModel)

    suspend fun deleteAllProduto()

}