package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_R_OS_ATIV
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ROSAtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateROSAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateROSAtivImpl @Inject constructor(
    private val rOSAtivRepository: ROSAtivRepository
): UpdateROSAtiv {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateROSAtiv = contador
            emit(ResultUpdateDataBase(++contUpdateROSAtiv,TEXT_CLEAR_TB + TB_R_OS_ATIV, qtde))
            rOSAtivRepository.deleteAllROSAtiv()
            emit(ResultUpdateDataBase(++contUpdateROSAtiv,TEXT_RECEIVE_WS_TB + TB_R_OS_ATIV, qtde))
            rOSAtivRepository.recoverAllROSAtiv()
                .collect{ result ->
                    result.onSuccess { rOSAtivList ->
                        emit(ResultUpdateDataBase(++contUpdateROSAtiv,TEXT_SAVE_DATA_TB + TB_R_OS_ATIV, qtde))
                        rOSAtivRepository.addAllROSAtiv(rOSAtivList)
                    }
                }
        }
    }

}