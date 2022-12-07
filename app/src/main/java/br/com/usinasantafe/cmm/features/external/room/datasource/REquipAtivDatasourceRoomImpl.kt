package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.REquipAtivModel
import br.com.usinasantafe.cmm.features.external.room.dao.REquipAtivDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.REquipAtivDatasourceRoom
import javax.inject.Inject

class REquipAtivDatasourceRoomImpl @Inject constructor (
    private val rEquipAtivDao: REquipAtivDao
): REquipAtivDatasourceRoom {

    override suspend fun addAllREquipAtiv(vararg rEquipAtivModels: REquipAtivModel) {
        rEquipAtivDao.insertAll(*rEquipAtivModels)
    }

    override suspend fun deleteAllREquipAtiv() {
        rEquipAtivDao.deleteAll()
    }

    override suspend fun listREquipAtiv(idEquip: Long): List<REquipAtivModel> {
        return rEquipAtivDao.listIdEquip(idEquip)
    }

}