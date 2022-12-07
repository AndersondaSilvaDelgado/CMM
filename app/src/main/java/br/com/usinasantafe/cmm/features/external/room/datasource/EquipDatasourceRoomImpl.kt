package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.EquipModel
import br.com.usinasantafe.cmm.features.external.room.dao.EquipDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.EquipDatasourceRoom
import javax.inject.Inject

class EquipDatasourceRoomImpl @Inject constructor (
    private val equipDao: EquipDao
): EquipDatasourceRoom {

    override suspend fun addAllEquip(vararg equipModels: EquipModel) {
        equipDao.insertAll(*equipModels)
    }

    override suspend fun deleteAllEquip() {
        equipDao.deleteAll()
    }

    override suspend fun getEquipNro(nroEquip: Long): EquipModel {
        return equipDao.getNro(nroEquip)
    }

    override suspend fun getEquipId(idEquip: Long): EquipModel {
        return equipDao.getId(idEquip)
    }

}