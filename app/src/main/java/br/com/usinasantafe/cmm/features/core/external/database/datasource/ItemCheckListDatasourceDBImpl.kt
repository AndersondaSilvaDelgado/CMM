package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.ItemCheckListModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.ItemCheckListDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ItemCheckListDatasourceDB
import javax.inject.Inject

class ItemCheckListDatasourceDBImpl @Inject constructor (
    private val itemCheckListDao: ItemCheckListDao
): ItemCheckListDatasourceDB {

    override suspend fun addItemCheckList(itemCheckListModel: ItemCheckListModel): Long {
        return itemCheckListDao.insert(itemCheckListModel)
    }

    override suspend fun deleteAllItemCheckList() {
        itemCheckListDao.deleteAll()
    }

}