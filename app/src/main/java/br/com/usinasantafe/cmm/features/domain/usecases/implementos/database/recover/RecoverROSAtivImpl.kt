package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.TB_R_OS_ATIV
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ROSAtivRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverROSAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverROSAtivImpl @Inject constructor(
    private val rOSAtivRepository: ROSAtivRepository
): RecoverROSAtiv {

    override suspend fun invoke(nroOS: String, contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contRecoverROSAtiv = contador
            emit(ResultUpdateDatabase(++contRecoverROSAtiv,TEXT_CLEAR_TB + TB_R_OS_ATIV, qtde))
            rOSAtivRepository.deleteAllROSAtiv()
            emit(ResultUpdateDatabase(++contRecoverROSAtiv,TEXT_RECEIVE_WS_TB + TB_R_OS_ATIV, qtde))
            rOSAtivRepository.recoverROSAtiv(nroOS)
                .collect{ result ->
                    result.onSuccess { rOSAtivList ->
                        emit(ResultUpdateDatabase(++contRecoverROSAtiv,TEXT_SAVE_DATA_TB + TB_R_OS_ATIV, qtde))
                        rOSAtivRepository.addAllROSAtiv(rOSAtivList)
                    }
                }
        }
    }

}