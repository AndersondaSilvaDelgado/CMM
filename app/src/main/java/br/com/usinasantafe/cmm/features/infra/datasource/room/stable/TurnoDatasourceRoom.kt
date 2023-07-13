package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.TurnoRoomModel

interface TurnoDatasourceRoom {

    suspend fun addAllTurno(vararg turnoRoomModels: TurnoRoomModel)

    suspend fun deleteAllTurno()

    suspend fun hasTurno(): Boolean

    suspend fun listTurno(codTurno: Long): List<TurnoRoomModel>

}