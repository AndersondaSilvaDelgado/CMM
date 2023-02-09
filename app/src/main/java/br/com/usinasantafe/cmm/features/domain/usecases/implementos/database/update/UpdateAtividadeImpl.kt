package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_ATIVIDADE
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtividadeRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateAtividade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateAtividadeImpl @Inject constructor(
    private val atividadeRepository: AtividadeRepository
): UpdateAtividade {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateAtividade = contador
            emit(ResultUpdateDataBase(++contUpdateAtividade, TEXT_CLEAR_TB + TB_ATIVIDADE, qtde))
            atividadeRepository.deleteAllAtividade()
            emit(ResultUpdateDataBase(++contUpdateAtividade, TEXT_RECEIVE_WS_TB + TB_ATIVIDADE, qtde))
            atividadeRepository.recoverAllAtividade()
                .collect{ result ->
                    result.onSuccess { ativList ->
                        emit(ResultUpdateDataBase(++contUpdateAtividade, TEXT_SAVE_DATA_TB + TB_ATIVIDADE, qtde))
                        atividadeRepository.addAllAtividade(ativList)
                    }
                }
        }
    }

}