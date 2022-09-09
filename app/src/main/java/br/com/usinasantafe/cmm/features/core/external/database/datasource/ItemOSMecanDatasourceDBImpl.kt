package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.ItemOSMecanModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.ItemOSMecanDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ItemOSMecanDatasourceDB
import javax.inject.Inject

class ItemOSMecanDatasourceDBImpl @Inject constructor (
    private val itemOSMecanDao: ItemOSMecanDao
): ItemOSMecanDatasourceDB {

    override suspend fun addItemOSMecan(itemOSMecanModel: ItemOSMecanModel): Long {
        return itemOSMecanDao.insert(itemOSMecanModel)
    }

    override suspend fun deleteAllItemOSMecan() {
        itemOSMecanDao.deleteAll()
    }
}