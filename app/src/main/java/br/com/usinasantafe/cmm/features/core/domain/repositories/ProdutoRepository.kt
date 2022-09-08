package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Produto

interface ProdutoRepository {

    suspend fun addAllProduto(produtoList: List<Produto>)

    suspend fun deleteAllProduto()

    suspend fun getAllProduto(): List<Produto>

}