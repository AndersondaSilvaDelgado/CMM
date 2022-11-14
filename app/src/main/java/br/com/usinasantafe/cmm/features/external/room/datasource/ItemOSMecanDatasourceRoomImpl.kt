package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.ItemOSMecanModel
import br.com.usinasantafe.cmm.features.external.room.dao.ItemOSMecanDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ItemOSMecanDatasourceRoom
import javax.inject.Inject

class ItemOSMecanDatasourceRoomImpl @Inject constructor (
    private val itemOSMecanDao: ItemOSMecanDao
): ItemOSMecanDatasourceRoom {

    override suspend fun addItemOSMecan(itemOSMecanModel: ItemOSMecanModel): Long {
        return itemOSMecanDao.insert(itemOSMecanModel)
    }

    override suspend fun deleteAllItemOSMecan() {
        itemOSMecanDao.deleteAll()
    }
}