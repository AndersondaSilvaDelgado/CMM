package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.REquipAtivModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.REquipAtivDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.REquipAtivDatasourceRoom
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