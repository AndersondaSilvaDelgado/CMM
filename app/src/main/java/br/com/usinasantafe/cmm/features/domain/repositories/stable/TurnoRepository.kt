package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Turno
import kotlinx.coroutines.flow.Flow

interface TurnoRepository {

    suspend fun addAllTurno(rOSAtivList: List<Turno>)

    suspend fun deleteAllTurno()

    suspend fun getAllTurno(): Flow<Result<List<Turno>>>

    suspend fun hasTurno(): Boolean

}