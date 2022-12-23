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

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateProduto = contador
            emit(ResultUpdateDataBase(++contUpdateProduto,"Limpando Dados da Tabela Produto", qtde))
            produtoRepository.deleteAllProduto()
            emit(ResultUpdateDataBase(++contUpdateProduto,"Recebendo Dados da Tabela Produto", qtde))
            produtoRepository.recoverAllProduto()
                .collect{ result ->
                    result.onSuccess { produtoList ->
                        emit(ResultUpdateDataBase(++contUpdateProduto,"Salvandos Dados da Tabela Produto", qtde))
                        produtoRepository.addAllProduto(produtoList)
                    }
                }
        }
    }

}