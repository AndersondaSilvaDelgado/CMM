package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ProdutoModel

interface ProdutoDatasourceRoom {

    suspend fun addProduto(produtoModel: ProdutoModel): Long

    suspend fun deleteAllProduto()

}