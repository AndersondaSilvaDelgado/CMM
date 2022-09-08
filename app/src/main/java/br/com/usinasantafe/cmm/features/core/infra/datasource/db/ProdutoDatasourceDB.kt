package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ProdutoModel

interface ProdutoDatasourceDB {

    suspend fun addProduto(produtoModel: ProdutoModel): Long

    suspend fun deleteAllProduto()

}