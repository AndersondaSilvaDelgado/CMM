package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.OSModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.OSDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.OSDatasourceDB
import javax.inject.Inject

class OSDatasourceDBImpl @Inject constructor (
    private val osDao: OSDao
): OSDatasourceDB {

    override suspend fun addOS(osModel: OSModel): Long {
        return osDao.insert(osModel)
    }

    override suspend fun deleteAllOS() {
        osDao.deleteAll()
    }

}