package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemCheckListRoomModel

interface ItemCheckListDatasourceRoom {

    suspend fun addAllItemCheckList(vararg itemCheckListRoomModels: ItemCheckListRoomModel)

    suspend fun deleteAllItemCheckList()

}