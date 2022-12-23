package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ItemCheckListModel

interface ItemCheckListDatasourceRoom {

    suspend fun addAllItemCheckList(vararg itemCheckListModels: ItemCheckListModel)

    suspend fun deleteAllItemCheckList()

}