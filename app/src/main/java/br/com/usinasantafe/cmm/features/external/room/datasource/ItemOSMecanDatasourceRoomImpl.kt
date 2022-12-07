package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.ItemOSMecanModel
import br.com.usinasantafe.cmm.features.external.room.dao.ItemOSMecanDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ItemOSMecanDatasourceRoom
import javax.inject.Inject

class ItemOSMecanDatasourceRoomImpl @Inject constructor (
    private val itemOSMecanDao: ItemOSMecanDao
): ItemOSMecanDatasourceRoom {

    override suspend fun addAllItemOSMecan(vararg itemOSMecanModels: ItemOSMecanModel) {
        itemOSMecanDao.insertAll(*itemOSMecanModels)
    }

    override suspend fun deleteAllItemOSMecan() {
        itemOSMecanDao.deleteAll()
    }
}