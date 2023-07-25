package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_SERVICO
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ServicoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateServico
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateServicoImpl @Inject constructor(
    private val servicoRepository: ServicoRepository
): UpdateServico {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateServico = contador
            emit(ResultUpdateDatabase(++contUpdateServico,TEXT_CLEAR_TB + TB_SERVICO, qtde))
            servicoRepository.deleteAllServico()
            emit(ResultUpdateDatabase(++contUpdateServico,TEXT_RECEIVE_WS_TB + TB_SERVICO, qtde))
            servicoRepository.recoverAllServico()
                .collect{ result ->
                    result.onSuccess { servicoList ->
                        emit(ResultUpdateDatabase(++contUpdateServico,TEXT_SAVE_DATA_TB + TB_SERVICO, qtde))
                        servicoRepository.addAllServico(servicoList)
                    }
                }
        }
    }

}