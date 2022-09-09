package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.BocalModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.BocalDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.BocalDatasourceDB
import javax.inject.Inject

class BocalDatasourceDBImpl @Inject constructor (
    private val bocalDao: BocalDao
): BocalDatasourceDB {

    override suspend fun addBocal(bocalModel: BocalModel): Long {
        return bocalDao.insert(bocalModel)
    }

    override suspend fun deleteAllBocal() {
        bocalDao.deleteAll()
    }

}