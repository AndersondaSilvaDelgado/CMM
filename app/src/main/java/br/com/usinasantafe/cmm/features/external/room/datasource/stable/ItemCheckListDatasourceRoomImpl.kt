package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemCheckListRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ItemCheckListDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ItemCheckListDatasourceRoom
import javax.inject.Inject

class ItemCheckListDatasourceRoomImpl @Inject constructor (
    private val itemCheckListDao: ItemCheckListDao
): ItemCheckListDatasourceRoom {

    override suspend fun addAllItemCheckList(vararg itemCheckListRoomModels: ItemCheckListRoomModel) {
        itemCheckListDao.insertAll(*itemCheckListRoomModels)
    }

    override suspend fun deleteAllItemCheckList() {
        itemCheckListDao.deleteAll()
    }

}