package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.BocalRoomModel

interface BocalDatasourceRoom {

    suspend fun addAllBocal(vararg bocalRoomModels: BocalRoomModel)

    suspend fun deleteAllBocal()

}