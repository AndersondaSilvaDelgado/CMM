package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.TurnoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateTurno
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateTurnoImpl @Inject constructor(
    private val turnoRepository: TurnoRepository
): UpdateTurno {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateTurno = contador
            emit(ResultUpdateDataBase(++contUpdateTurno,"Limpando Dados da Tabela Turno", qtde))
            turnoRepository.deleteAllTurno()
            emit(ResultUpdateDataBase(++contUpdateTurno,"Recebendo Dados da Tabela Turno", qtde))
            turnoRepository.recoverAllTurno()
                .collect{ result ->
                    result.onSuccess { turnoList ->
                        emit(ResultUpdateDataBase(++contUpdateTurno,"Salvandos Dados da Tabela Turno", qtde))
                        turnoRepository.addAllTurno(turnoList)
                    }
                }
        }
    }

}