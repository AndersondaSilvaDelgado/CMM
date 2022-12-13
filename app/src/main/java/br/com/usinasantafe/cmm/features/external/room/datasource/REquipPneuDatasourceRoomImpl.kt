package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.stable.REquipPneuModel
import br.com.usinasantafe.cmm.features.external.room.dao.REquipPneuDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.REquipPneuDatasourceRoom
import javax.inject.Inject

class REquipPneuDatasourceRoomImpl @Inject constructor (
    private val rEquipPneuDao: REquipPneuDao
): REquipPneuDatasourceRoom {

    override suspend fun addAllREquipPneu(vararg rEquipPneuModels: REquipPneuModel) {
        rEquipPneuDao.insertAll(*rEquipPneuModels)
    }

    override suspend fun deleteAllREquipPneu() {
       rEquipPneuDao.deleteAll()
    }
}