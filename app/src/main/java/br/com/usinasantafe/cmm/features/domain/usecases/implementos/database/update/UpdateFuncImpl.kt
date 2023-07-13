package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_FUNC
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.FuncRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateFunc
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateFuncImpl @Inject constructor(
    private val funcRepository: FuncRepository
): UpdateFunc {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateFunc = contador
            emit(ResultUpdateDatabase(++contUpdateFunc, TEXT_CLEAR_TB + TB_FUNC, qtde))
            funcRepository.deleteAllFunc()
            emit(ResultUpdateDatabase(++contUpdateFunc,TEXT_RECEIVE_WS_TB + TB_FUNC, qtde))
            funcRepository.recoverAllFunc()
                .collect{ result ->
                    result.onSuccess { funcList ->
                        emit(ResultUpdateDatabase(++contUpdateFunc,TEXT_SAVE_DATA_TB + TB_FUNC, qtde))
                        funcRepository.addAllFunc(funcList)
                    }
                }
        }
    }

}