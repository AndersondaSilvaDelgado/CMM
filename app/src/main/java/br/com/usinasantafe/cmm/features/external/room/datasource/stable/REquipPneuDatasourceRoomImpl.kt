package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipPneuRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.REquipPneuDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.REquipPneuDatasourceRoom
import javax.inject.Inject

class REquipPneuDatasourceRoomImpl @Inject constructor (
    private val rEquipPneuDao: REquipPneuDao
): REquipPneuDatasourceRoom {

    override suspend fun addAllREquipPneu(vararg rEquipPneuRoomModels: REquipPneuRoomModel) {
        rEquipPneuDao.insertAll(*rEquipPneuRoomModels)
    }

    override suspend fun deleteAllREquipPneu() {
       rEquipPneuDao.deleteAll()
    }
}