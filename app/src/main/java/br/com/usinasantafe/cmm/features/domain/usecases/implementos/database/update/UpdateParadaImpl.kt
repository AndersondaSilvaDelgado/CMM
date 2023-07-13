package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_PARADA
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ParadaRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateParadaImpl @Inject constructor(
    private val paradaRepository: ParadaRepository
): UpdateParada {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateParada = contador
            emit(ResultUpdateDatabase(++contUpdateParada,TEXT_CLEAR_TB + TB_PARADA, qtde))
            paradaRepository.deleteAllParada()
            emit(ResultUpdateDatabase(++contUpdateParada,TEXT_RECEIVE_WS_TB + TB_PARADA, qtde))
            paradaRepository.recoverAllParada()
                .collect{ result ->
                    result.onSuccess { paradaList ->
                        emit(ResultUpdateDatabase(++contUpdateParada,TEXT_SAVE_DATA_TB + TB_PARADA, qtde))
                        paradaRepository.addAllParada(paradaList)
                    }
                }
        }
    }

}