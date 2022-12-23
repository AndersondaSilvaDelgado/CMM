package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import kotlinx.coroutines.flow.Flow

interface TurnoRepository {

    suspend fun addAllTurno(turnoList: List<Turno>)

    suspend fun deleteAllTurno()

    suspend fun recoverAllTurno(): Flow<Result<List<Turno>>>

    suspend fun hasTurno(): Boolean

    suspend fun listTurno(codTurno: Long): List<Turno>

}