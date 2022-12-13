package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ProdutoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateProduto
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateProdutoImpl @Inject constructor(
    private val produtoRepository: ProdutoRepository
): UpdateProduto {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Produto", size))
            produtoRepository.deleteAllProduto()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Produto", size))
            produtoRepository.recoverAllProduto()
                .collect{ result ->
                    result.onSuccess { produtoList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Produto", size))
                        produtoRepository.addAllProduto(produtoList)
                    }
                }
        }
    }

}