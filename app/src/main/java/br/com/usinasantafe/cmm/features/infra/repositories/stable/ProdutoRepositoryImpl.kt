package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Produto
import br.com.usinasantafe.cmm.features.infra.models.toProduto
import br.com.usinasantafe.cmm.features.infra.models.toProdutoModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ProdutoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ProdutoDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ProdutoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProdutoRepositoryImpl @Inject constructor(
    private val produtoDatasourceRoom: ProdutoDatasourceRoom,
    private val produtoDatasourceWebService: ProdutoDatasourceWebService
): ProdutoRepository {

    override suspend fun addAllProduto(produtoList: List<Produto>) {
        for(produto in produtoList){
            val produtoModel = produto.toProdutoModel()
            produtoDatasourceRoom.addProduto(produtoModel)
        }
    }

    override suspend fun deleteAllProduto() {
        produtoDatasourceRoom.deleteAllProduto()
    }

    override suspend fun getAllProduto(): Flow<Result<List<Produto>>> {
        return flow {
            produtoDatasourceWebService.getAllProduto()
                .collect { result ->
                    result.onSuccess {produtoModelList ->
                        val produtoList = mutableListOf<Produto>()
                        for (produtoModel in produtoModelList){
                            produtoList.add(produtoModel.toProduto())
                        }
                        emit(Result.success(produtoList))
                    }
                }
        }
    }

}