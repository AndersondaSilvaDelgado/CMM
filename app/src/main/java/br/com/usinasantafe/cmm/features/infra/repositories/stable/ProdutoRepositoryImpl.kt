package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Produto
import br.com.usinasantafe.cmm.features.infra.models.toProduto
import br.com.usinasantafe.cmm.features.infra.models.toProdutoModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ProdutoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ProdutoDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ProdutoDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toPressaoBocalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProdutoRepositoryImpl @Inject constructor(
    private val produtoDatasourceRoom: ProdutoDatasourceRoom,
    private val produtoDatasourceWebService: ProdutoDatasourceWebService
): ProdutoRepository {

    override suspend fun addAllProduto(produtoList: List<Produto>) {
        produtoDatasourceRoom.addAllProduto(*produtoList.map { it.toProdutoModel() }.toTypedArray())
    }

    override suspend fun deleteAllProduto() {
        produtoDatasourceRoom.deleteAllProduto()
    }

    override suspend fun recoverAllProduto(): Flow<Result<List<Produto>>> {
        return flow {
            produtoDatasourceWebService.getAllProduto()
                .collect { result ->
                    result.onSuccess {produtoModelList ->
                        emit(Result.success(produtoModelList.map { it.toProduto() }))
                    }
                }
        }
    }

}