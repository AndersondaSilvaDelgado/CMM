package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.EquipSegModel
import br.com.usinasantafe.cmm.features.external.room.dao.EquipSegDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.EquipSegDatasourceRoom
import javax.inject.Inject

class EquipSegDatasourceRoomImpl @Inject constructor (
    private val equipSegDao: EquipSegDao
): EquipSegDatasourceRoom {

    override suspend fun addEquipSeg(equipSegModel: EquipSegModel): Long {
        return equipSegDao.insert(equipSegModel)
    }

    override suspend fun deleteAllEquipSeg() {
        equipSegDao.deleteAll()
    }

}