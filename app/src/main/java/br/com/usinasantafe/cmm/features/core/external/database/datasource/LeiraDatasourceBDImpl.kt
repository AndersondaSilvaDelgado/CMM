package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.LeiraModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.LeiraDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.LeiraDatasourceBD
import javax.inject.Inject

class LeiraDatasourceBDImpl @Inject constructor (
    private val leiraDao: LeiraDao
): LeiraDatasourceBD {

    override suspend fun addLeira(leiraModel: LeiraModel): Long {
        return leiraDao.insert(leiraModel)
    }

    override suspend fun deleteAllLeira() {
        leiraDao.deleteAll()
    }

}