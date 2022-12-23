package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ProdutoModel

interface ProdutoDatasourceRoom {

    suspend fun addAllProduto(vararg produtoModels: ProdutoModel)

    suspend fun deleteAllProduto()

}