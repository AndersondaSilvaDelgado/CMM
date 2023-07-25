package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_ATIVIDADE
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateAtividade
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateAtividadeImpl @Inject constructor(
    private val ativRepository: AtivRepository
): UpdateAtividade {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateAtividade = contador
            emit(ResultUpdateDatabase(++contUpdateAtividade, TEXT_CLEAR_TB + TB_ATIVIDADE, qtde))
            ativRepository.deleteAllAtiv()
            emit(ResultUpdateDatabase(++contUpdateAtividade, TEXT_RECEIVE_WS_TB + TB_ATIVIDADE, qtde))
            ativRepository.recoverAllAtiv()
                .collect{ result ->
                    result.onSuccess { ativList ->
                        emit(ResultUpdateDatabase(++contUpdateAtividade, TEXT_SAVE_DATA_TB + TB_ATIVIDADE, qtde))
                        ativRepository.addAllAtiv(ativList)
                    }
                }
        }
    }

}