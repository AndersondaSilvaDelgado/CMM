package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_PRODUTO
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ProdutoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateProduto
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateProdutoImpl @Inject constructor(
    private val produtoRepository: ProdutoRepository
): UpdateProduto {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateProduto = contador
            emit(ResultUpdateDatabase(++contUpdateProduto,TEXT_CLEAR_TB + TB_PRODUTO, qtde))
            produtoRepository.deleteAllProduto()
            emit(ResultUpdateDatabase(++contUpdateProduto,TEXT_RECEIVE_WS_TB + TB_PRODUTO, qtde))
            produtoRepository.recoverAllProduto()
                .collect{ result ->
                    result.onSuccess { produtoList ->
                        emit(ResultUpdateDatabase(++contUpdateProduto,TEXT_SAVE_DATA_TB + TB_PRODUTO, qtde))
                        produtoRepository.addAllProduto(produtoList)
                    }
                }
        }
    }

}