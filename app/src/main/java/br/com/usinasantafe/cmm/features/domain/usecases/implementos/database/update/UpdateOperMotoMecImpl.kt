package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_OPER_MOTOMEC
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OperMotoMecRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateOperMotoMec
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateOperMotoMecImpl @Inject constructor(
    private val operMotoMecRepository: OperMotoMecRepository
): UpdateOperMotoMec {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateMotoMec = contador
            emit(ResultUpdateDatabase(++contUpdateMotoMec,TEXT_CLEAR_TB + TB_OPER_MOTOMEC, qtde))
            operMotoMecRepository.deleteAllOperMotoMec()
            emit(ResultUpdateDatabase(++contUpdateMotoMec,TEXT_RECEIVE_WS_TB + TB_OPER_MOTOMEC, qtde))
            operMotoMecRepository.recoverAllOperMotoMec()
                .collect{ result ->
                    result.onSuccess { motoMecList ->
                        emit(ResultUpdateDatabase(++contUpdateMotoMec,TEXT_SAVE_DATA_TB + TB_OPER_MOTOMEC, qtde))
                        operMotoMecRepository.addAllOperMotoMec(motoMecList)
                    }
                }
        }
    }

}