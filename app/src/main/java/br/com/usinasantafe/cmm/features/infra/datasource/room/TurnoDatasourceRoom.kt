package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.TurnoModel

interface TurnoDatasourceRoom {

    suspend fun addTurno(turnoModel: TurnoModel): Long

    suspend fun deleteAllTurno()

    suspend fun hasTurno(): Boolean

}