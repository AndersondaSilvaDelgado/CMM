package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.common.utils.*
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverOS
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverROSAtiv
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverOSImpl @Inject constructor(
    private val osRepository: OSRepository,
    private val rOSAtiv: RecoverROSAtiv
): RecoverOS {

    override suspend fun invoke(nroOS: String, contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contRecoverOS = contador
            emit(ResultUpdateDataBase(++contRecoverOS,TEXT_CLEAR_TB + TB_OS, qtde))
            osRepository.deleteAllOS()
            emit(ResultUpdateDataBase(++contRecoverOS,TEXT_RECEIVE_WS_TB + TB_OS, qtde))
            osRepository.recoverOS(nroOS)
                .collect{ result ->
                    result.onSuccess { osList ->
                        if(osList.isNotEmpty()){
                            emit(ResultUpdateDataBase(++contRecoverOS, TEXT_SAVE_DATA_TB + TB_OS, qtde))
                            osRepository.addAllOS(osList)
                            rOSAtiv(nroOS, contRecoverOS, qtde).collect{
                                emit(it)
                                contRecoverOS = it.count;
                            }
                            emit(ResultUpdateDataBase(qtde, TEXT_FINISH_UPDATE, qtde))
                        } else {
                            emit(ResultUpdateDataBase(qtde, WEB_RETURN_CLEAR_OS, qtde))
                        }
                    }
                }
        }
    }

}