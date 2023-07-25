package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.EquipRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.EquipDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.EquipDatasourceRoom
import javax.inject.Inject

class EquipDatasourceRoomImpl @Inject constructor (
    private val equipDao: EquipDao
): EquipDatasourceRoom {

    override suspend fun addAllEquip(vararg equipRoomModels: EquipRoomModel) {
        equipDao.insertAll(*equipRoomModels)
    }

    override suspend fun updateHorimetroEquip(horimetro: Double): Boolean {
        var equip = equipDao.get()
        equip.horimetroEquip = horimetro
        return equipDao.update(equip) > 0
    }

    override suspend fun deleteAllEquip() {
        equipDao.deleteAll()
    }

    override suspend fun getEquip(): EquipRoomModel {
        return equipDao.get()
    }

    override suspend fun hasEquip(): Boolean {
        return (equipDao.count() > 0)
    }

}