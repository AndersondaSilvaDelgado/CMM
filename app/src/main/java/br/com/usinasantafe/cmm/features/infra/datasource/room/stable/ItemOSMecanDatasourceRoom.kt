package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemOSMecanRoomModel

interface ItemOSMecanDatasourceRoom {

    suspend fun addAllItemOSMecan(vararg itemOSMecanRoomModels: ItemOSMecanRoomModel)

    suspend fun deleteAllItemOSMecan()

}