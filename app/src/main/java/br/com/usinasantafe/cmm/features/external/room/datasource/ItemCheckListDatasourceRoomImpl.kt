package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.ItemCheckListModel
import br.com.usinasantafe.cmm.features.external.room.dao.ItemCheckListDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ItemCheckListDatasourceRoom
import javax.inject.Inject

class ItemCheckListDatasourceRoomImpl @Inject constructor (
    private val itemCheckListDao: ItemCheckListDao
): ItemCheckListDatasourceRoom {

    override suspend fun addItemCheckList(itemCheckListModel: ItemCheckListModel): Long {
        return itemCheckListDao.insert(itemCheckListModel)
    }

    override suspend fun deleteAllItemCheckList() {
        itemCheckListDao.deleteAll()
    }

}