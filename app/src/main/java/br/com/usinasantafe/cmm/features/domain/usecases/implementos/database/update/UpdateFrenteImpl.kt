package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_FRENTE
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.FrenteRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateFrente
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateFrenteImpl @Inject constructor(
    private val frenteRepository: FrenteRepository
): UpdateFrente {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateFrente = contador
            emit(ResultUpdateDataBase(++contUpdateFrente,TEXT_CLEAR_TB + TB_FRENTE, qtde))
            frenteRepository.deleteAllFrente()
            emit(ResultUpdateDataBase(++contUpdateFrente,TEXT_RECEIVE_WS_TB + TB_FRENTE, qtde))
            frenteRepository.recoverAllFrente()
                .collect{ result ->
                    result.onSuccess { frenteList ->
                        emit(ResultUpdateDataBase(++contUpdateFrente,TEXT_SAVE_DATA_TB + TB_FRENTE, qtde))
                        frenteRepository.addAllFrente(frenteList)
                    }
                }
        }
    }

}