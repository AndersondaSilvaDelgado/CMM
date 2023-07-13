package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.LeiraRoomModel

interface LeiraDatasourceRoom {

    suspend fun addAllLeira(vararg leiraRoomModels: LeiraRoomModel)

    suspend fun deleteAllLeira()

}