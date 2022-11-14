package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.OSModel
import br.com.usinasantafe.cmm.features.external.room.dao.OSDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.OSDatasourceRoom
import javax.inject.Inject

class OSDatasourceRoomImpl @Inject constructor (
    private val osDao: OSDao
): OSDatasourceRoom {

    override suspend fun addOS(osModel: OSModel): Long {
        return osDao.insert(osModel)
    }

    override suspend fun deleteAllOS() {
        osDao.deleteAll()
    }

}