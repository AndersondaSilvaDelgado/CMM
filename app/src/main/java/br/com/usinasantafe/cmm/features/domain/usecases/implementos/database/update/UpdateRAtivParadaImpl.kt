package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_R_ATIV_PARADA
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateRAtivParadaImpl @Inject constructor(
    private val rAtivParadaRepository: RAtivParadaRepository
): UpdateRAtivParada {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateRAtivParada = contador
            emit(ResultUpdateDataBase(++contUpdateRAtivParada, TEXT_CLEAR_TB + TB_R_ATIV_PARADA, qtde))
            rAtivParadaRepository.deleteAllRAtivParada()
            emit(ResultUpdateDataBase(++contUpdateRAtivParada,TEXT_RECEIVE_WS_TB + TB_R_ATIV_PARADA, qtde))
            rAtivParadaRepository.recoverAllRAtivParada()
                .collect{ result ->
                    result.onSuccess { rAtivParadaList ->
                        emit(ResultUpdateDataBase(++contUpdateRAtivParada,TEXT_SAVE_DATA_TB + TB_R_ATIV_PARADA, qtde))
                        rAtivParadaRepository.addAllRAtivParada(rAtivParadaList)
                    }
                }
        }
    }

}