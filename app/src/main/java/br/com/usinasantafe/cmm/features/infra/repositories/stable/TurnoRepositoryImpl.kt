package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Turno
import br.com.usinasantafe.cmm.features.infra.models.toTurno
import br.com.usinasantafe.cmm.features.infra.models.toTurnoModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.TurnoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.TurnoDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.TurnoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TurnoRepositoryImpl @Inject constructor(
    private val turnoDatasourceRoom: TurnoDatasourceRoom,
    private val turnoDatasourceWebService: TurnoDatasourceWebService
): TurnoRepository {

    override suspend fun addAllTurno(turnoList: List<Turno>) {
        for(turno in turnoList){
            val turnoModel = turno.toTurnoModel()
            turnoDatasourceRoom.addTurno(turnoModel)
        }
    }

    override suspend fun deleteAllTurno() {
        turnoDatasourceRoom.deleteAllTurno()
    }

    override suspend fun getAllTurno(): Flow<Result<List<Turno>>> {
        return flow {
            turnoDatasourceWebService.getAllTurno()
                .collect { result ->
                    result.onSuccess {turnoModelList ->
                        val turnoList = mutableListOf<Turno>()
                        for (turnoModel in turnoModelList){
                            turnoList.add(turnoModel.toTurno())
                        }
                        emit(Result.success(turnoList))
                    }
                }
        }
    }

    override suspend fun hasTurno(): Boolean {
        return turnoDatasourceRoom.hasTurno()
    }

}


