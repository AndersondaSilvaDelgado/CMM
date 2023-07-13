package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.OSRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.OSDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.OSDatasourceRoom
import javax.inject.Inject

class OSDatasourceRoomImpl @Inject constructor (
    private val osDao: OSDao
): OSDatasourceRoom {

    override suspend fun addAllOS(vararg osRoomModels: OSRoomModel) {
        osDao.insertAll(*osRoomModels)
    }

    override suspend fun deleteAllOS() {
        osDao.deleteAll()
    }

    override suspend fun checkOS(nroOS: Long): Boolean {
        return (osDao.check(nroOS) > 0)
    }

    override suspend fun getOSNro(nroOS: Long): OSRoomModel {
        return osDao.getNroOS(nroOS)
    }

}