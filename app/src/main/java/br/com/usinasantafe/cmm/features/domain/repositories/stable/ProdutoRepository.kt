package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Produto
import kotlinx.coroutines.flow.Flow

interface ProdutoRepository {

    suspend fun addAllProduto(produtoList: List<Produto>)

    suspend fun deleteAllProduto()

    suspend fun recoverAllProduto(): Flow<Result<List<Produto>>>

}