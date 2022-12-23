package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import br.com.usinasantafe.cmm.features.infra.models.stable.toTurno
import br.com.usinasantafe.cmm.features.infra.models.stable.toTurnoModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.TurnoRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.TurnoDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.TurnoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TurnoRepositoryImpl @Inject constructor(
    private val turnoDatasourceRoom: TurnoDatasourceRoom,
    private val turnoDatasourceWebService: TurnoDatasourceWebService
): TurnoRepository {

    override suspend fun addAllTurno(turnoList: List<Turno>) {
        turnoDatasourceRoom.addAllTurno(*turnoList.map { it.toTurnoModel() }.toTypedArray())
    }

    override suspend fun deleteAllTurno() {
        turnoDatasourceRoom.deleteAllTurno()
    }

    override suspend fun recoverAllTurno(): Flow<Result<List<Turno>>> {
        return flow {
            turnoDatasourceWebService.getAllTurno()
                .collect { result ->
                    result.onSuccess {turnoModelList ->
                        emit(Result.success(turnoModelList.map { it.toTurno() }))
                    }
                }
        }
    }

    override suspend fun hasTurno(): Boolean {
        return turnoDatasourceRoom.hasTurno()
    }

    override suspend fun listTurno(codTurno: Long): List<Turno> {
        return turnoDatasourceRoom.listTurno(codTurno).map { it.toTurno() }
    }

}


