package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.ROSAtivModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.ROSAtivDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ROSAtivDatasourceDB
import javax.inject.Inject

class ROSAtivDatasourceDBImpl @Inject constructor (
    private val rOSAtivDao: ROSAtivDao
): ROSAtivDatasourceDB {

    override suspend fun addROSAtiv(rOSAtivModel: ROSAtivModel): Long {
        return rOSAtivDao.insert(rOSAtivModel)
    }

    override suspend fun deleteAllROSAtiv() {
        rOSAtivDao.deleteAll()
    }

}