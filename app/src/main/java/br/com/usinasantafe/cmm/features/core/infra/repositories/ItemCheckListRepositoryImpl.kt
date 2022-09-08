package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.ItemCheckList
import br.com.usinasantafe.cmm.features.core.infra.models.toItemCheckList
import br.com.usinasantafe.cmm.features.core.infra.models.toItemCheckListModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ItemCheckListDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ItemCheckListDatasourceWeb
import javax.inject.Inject

class ItemCheckListRepositoryImpl @Inject constructor(
    private val itemCheckListDatasourceDB: ItemCheckListDatasourceDB,
    private val itemCheckListDatasourceWeb: ItemCheckListDatasourceWeb
): ItemCheckListRepository {

    override suspend fun addAllItemCheckList(itemCheckListList: List<ItemCheckList>) {
        for(itemCheckList in itemCheckListList){
            val itemCheckListModel = itemCheckList.toItemCheckListModel()
            itemCheckListDatasourceDB.addItemCheckList(itemCheckListModel)
        }
    }

    override suspend fun deleteAllItemCheckList() {
        itemCheckListDatasourceDB.deleteAllItemCheckList()
    }

    override suspend fun getAllItemCheckList(): List<ItemCheckList> {
        val itemCheckListModelList = itemCheckListDatasourceWeb.getAllItemCheckList()
        val itemCheckListList = mutableListOf<ItemCheckList>()
        for (itemCheckListModel in itemCheckListModelList){
            itemCheckListList.add(itemCheckListModel.toItemCheckList())
        }
        return itemCheckListList
    }

}