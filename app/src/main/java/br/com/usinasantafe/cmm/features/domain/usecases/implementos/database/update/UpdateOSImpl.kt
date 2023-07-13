package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_OS
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateOS
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateOSImpl @Inject constructor(
    private val osRepository: OSRepository
): UpdateOS {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateOS = contador
            emit(ResultUpdateDatabase(++contUpdateOS,TEXT_CLEAR_TB + TB_OS, qtde))
            osRepository.deleteAllOS()
            emit(ResultUpdateDatabase(++contUpdateOS,TEXT_RECEIVE_WS_TB + TB_OS, qtde))
            osRepository.recoverAllOS()
                .collect{ result ->
                    result.onSuccess { osList ->
                        emit(ResultUpdateDatabase(++contUpdateOS,TEXT_SAVE_DATA_TB + TB_OS, qtde))
                        osRepository.addAllOS(osList)
                    }
                }
        }
    }

}