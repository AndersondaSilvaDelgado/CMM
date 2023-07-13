package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemOSMecanRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ItemOSMecanDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ItemOSMecanDatasourceRoom
import javax.inject.Inject

class ItemOSMecanDatasourceRoomImpl @Inject constructor (
    private val itemOSMecanDao: ItemOSMecanDao
): ItemOSMecanDatasourceRoom {

    override suspend fun addAllItemOSMecan(vararg itemOSMecanRoomModels: ItemOSMecanRoomModel) {
        itemOSMecanDao.insertAll(*itemOSMecanRoomModels)
    }

    override suspend fun deleteAllItemOSMecan() {
        itemOSMecanDao.deleteAll()
    }
}