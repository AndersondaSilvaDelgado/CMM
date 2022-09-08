package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Turno

interface TurnoRepository {

    suspend fun addAllTurno(rOSAtivList: List<Turno>)

    suspend fun deleteAllTurno()

    suspend fun getAllTurno(): List<Turno>

}