package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_LEIRA
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.LeiraRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateLeira
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateLeiraImpl @Inject constructor(
    private val leiraRepository: LeiraRepository
): UpdateLeira {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateLeira = contador
            emit(ResultUpdateDatabase(++contUpdateLeira, TEXT_CLEAR_TB + TB_LEIRA, qtde))
            leiraRepository.deleteAllLeira()
                    emit(ResultUpdateDatabase(++contUpdateLeira,TEXT_RECEIVE_WS_TB + TB_LEIRA, qtde))
            leiraRepository.recoverAllLeira()
                .collect{ result ->
                    result.onSuccess { leiraList ->
                        emit(ResultUpdateDatabase(++contUpdateLeira,TEXT_SAVE_DATA_TB + TB_LEIRA, qtde))
                        leiraRepository.addAllLeira(leiraList)
                    }
                }
        }
    }

}