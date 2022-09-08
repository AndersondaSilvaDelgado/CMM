package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.TurnoModel

interface TurnoDatasourceDB {

    suspend fun addTurno(turnoModel: TurnoModel): Long

    suspend fun deleteAllTurno()

}