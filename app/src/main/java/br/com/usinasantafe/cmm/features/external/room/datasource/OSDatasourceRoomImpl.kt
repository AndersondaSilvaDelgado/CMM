package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.OSModel
import br.com.usinasantafe.cmm.features.external.room.dao.OSDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.OSDatasourceRoom
import javax.inject.Inject

class OSDatasourceRoomImpl @Inject constructor (
    private val osDao: OSDao
): OSDatasourceRoom {

    override suspend fun addAllOS(vararg osModels: OSModel) {
        osDao.insertAll(*osModels)
    }

    override suspend fun deleteAllOS() {
        osDao.deleteAll()
    }

    override suspend fun checkOS(nroOS: Long): Boolean {
        return (osDao.check(nroOS) > 0)
    }

    override suspend fun getOSNro(nroOS: Long): OSModel {
        return osDao.getNroOS(nroOS)
    }

}