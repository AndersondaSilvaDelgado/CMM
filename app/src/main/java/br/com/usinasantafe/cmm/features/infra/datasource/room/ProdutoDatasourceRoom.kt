package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ProdutoModel

interface ProdutoDatasourceRoom {

    suspend fun addAllProduto(vararg produtoModels: ProdutoModel)

    suspend fun deleteAllProduto()

}