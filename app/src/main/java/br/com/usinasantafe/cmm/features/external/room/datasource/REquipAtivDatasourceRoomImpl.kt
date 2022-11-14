package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.REquipAtivModel
import br.com.usinasantafe.cmm.features.external.room.dao.REquipAtivDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.REquipAtivDatasourceRoom
import javax.inject.Inject

class REquipAtivDatasourceRoomImpl @Inject constructor (
    private val rEquipAtivDao: REquipAtivDao
): REquipAtivDatasourceRoom {

    override suspend fun addREquipAtiv(rEquipAtivModel: REquipAtivModel): Long {
        return rEquipAtivDao.insert(rEquipAtivModel)
    }

    override suspend fun deleteAllREquipAtiv() {
        rEquipAtivDao.deleteAll()
    }

}