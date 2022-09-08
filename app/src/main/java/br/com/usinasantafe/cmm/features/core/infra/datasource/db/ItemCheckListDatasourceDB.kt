package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ItemCheckListModel

interface ItemCheckListDatasourceDB {

    suspend fun addItemCheckList(itemCheckListModel: ItemCheckListModel): Long

    suspend fun deleteAllItemCheckList()

}