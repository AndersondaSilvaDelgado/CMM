package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.EquipSegModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.EquipSegDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.EquipSegDatasourceRoom
import javax.inject.Inject

class EquipSegDatasourceRoomImpl @Inject constructor (
    private val equipSegDao: EquipSegDao
): EquipSegDatasourceRoom {

    override suspend fun addAllEquipSeg(vararg equipSegModels: EquipSegModel) {
        equipSegDao.insertAll(*equipSegModels)
    }

    override suspend fun deleteAllEquipSeg() {
        equipSegDao.deleteAll()
    }

}