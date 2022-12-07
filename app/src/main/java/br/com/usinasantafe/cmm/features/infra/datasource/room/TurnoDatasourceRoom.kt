package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.TurnoModel

interface TurnoDatasourceRoom {

    suspend fun addAllTurno(vararg turnoModels: TurnoModel)

    suspend fun deleteAllTurno()

    suspend fun hasTurno(): Boolean

    suspend fun listTurno(codTurno: Long): List<TurnoModel>

}