package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ItemCheckListModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ItemCheckListDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ItemCheckListDatasourceRoom
import javax.inject.Inject

class ItemCheckListDatasourceRoomImpl @Inject constructor (
    private val itemCheckListDao: ItemCheckListDao
): ItemCheckListDatasourceRoom {

    override suspend fun addAllItemCheckList(vararg itemCheckListModels: ItemCheckListModel) {
        itemCheckListDao.insertAll(*itemCheckListModels)
    }

    override suspend fun deleteAllItemCheckList() {
        itemCheckListDao.deleteAll()
    }

}