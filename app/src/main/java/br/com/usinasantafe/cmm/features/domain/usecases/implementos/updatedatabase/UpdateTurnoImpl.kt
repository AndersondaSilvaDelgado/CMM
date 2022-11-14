package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.TurnoRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateTurno
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateTurnoImpl @Inject constructor(
    private val turnoRepository: TurnoRepository
): UpdateTurno {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count,"Limpando Dados da Tabela Turno", size))
            turnoRepository.deleteAllTurno()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela Turno", size))
            turnoRepository.getAllTurno()
                .collect{ result ->
                    result.onSuccess { turnoList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela Turno", size))
                        turnoRepository.addAllTurno(turnoList)
                    }
                }
        }
    }

}