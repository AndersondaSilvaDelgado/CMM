package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.common.utils.TB_TURNO
import br.com.usinasantafe.cmm.common.utils.TEXT_CLEAR_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_RECEIVE_WS_TB
import br.com.usinasantafe.cmm.common.utils.TEXT_SAVE_DATA_TB
import br.com.usinasantafe.cmm.features.domain.repositories.stable.TurnoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateTurno
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateTurnoImpl @Inject constructor(
    private val turnoRepository: TurnoRepository
): UpdateTurno {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDatabase> {
        return flow {
            var contUpdateTurno = contador
            emit(ResultUpdateDatabase(++contUpdateTurno,TEXT_CLEAR_TB + TB_TURNO, qtde))
            turnoRepository.deleteAllTurno()
            emit(ResultUpdateDatabase(++contUpdateTurno,TEXT_RECEIVE_WS_TB + TB_TURNO, qtde))
            turnoRepository.recoverAllTurno()
                .collect{ result ->
                    result.onSuccess { turnoList ->
                        emit(ResultUpdateDatabase(++contUpdateTurno,TEXT_SAVE_DATA_TB + TB_TURNO, qtde))
                        turnoRepository.addAllTurno(turnoList)
                    }
                }
        }
    }

}