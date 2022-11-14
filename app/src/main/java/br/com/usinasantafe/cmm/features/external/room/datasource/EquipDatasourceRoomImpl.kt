package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.EquipModel
import br.com.usinasantafe.cmm.features.external.room.dao.EquipDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.EquipDatasourceRoom
import javax.inject.Inject

class EquipDatasourceRoomImpl @Inject constructor (
    private val equipDao: EquipDao
): EquipDatasourceRoom {

    override suspend fun addEquip(equipModel: EquipModel): Long {
        return equipDao.insert(equipModel)
    }

    override suspend fun deleteAllEquip() {
        equipDao.deleteAll()
    }

}