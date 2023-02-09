package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_R_FUNCAO_ATIV_PARADA
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateRFuncaoAtivParadaImpl @Inject constructor(
    private val rFuncaoAtivParadaRepository: RFuncaoAtivParadaRepository
): UpdateRFuncaoAtivParada {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateRFuncaoAtivParada = contador
            emit(ResultUpdateDataBase(++contUpdateRFuncaoAtivParada,TEXT_CLEAR_TB + TB_R_FUNCAO_ATIV_PARADA, qtde))
            rFuncaoAtivParadaRepository.deleteAllRFuncaoAtivParada()
            emit(ResultUpdateDataBase(++contUpdateRFuncaoAtivParada,TEXT_RECEIVE_WS_TB + TB_R_FUNCAO_ATIV_PARADA, qtde))
            rFuncaoAtivParadaRepository.recoverAllRFuncaoAtivParada()
                .collect{ result ->
                    result.onSuccess { rFuncaoAtivParadaList ->
                        emit(ResultUpdateDataBase(++contUpdateRFuncaoAtivParada,TEXT_SAVE_DATA_TB + TB_R_FUNCAO_ATIV_PARADA, qtde))
                        rFuncaoAtivParadaRepository.addAllRFuncaoAtivParada(rFuncaoAtivParadaList)
                    }
                }
        }
    }

}