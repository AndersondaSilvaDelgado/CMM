package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipPneuRoomModel

interface REquipPneuDatasourceRoom {

    suspend fun addAllREquipPneu(vararg rEquipPneuRoomModels: REquipPneuRoomModel)

    suspend fun deleteAllREquipPneu()

}