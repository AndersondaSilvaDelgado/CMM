package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.FrenteRoomModel

interface FrenteDatasourceRoom {

    suspend fun addAllFrente(vararg frenteRoomModels: FrenteRoomModel)

    suspend fun deleteAllFrente()

}