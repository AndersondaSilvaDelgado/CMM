package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.RAtivParadaModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.RAtivParadaDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.RAtivParadaDatasourceDB
import javax.inject.Inject

class RAtivParadaDatasourceDBImpl @Inject constructor (
    private val rAtivParadaDao: RAtivParadaDao
): RAtivParadaDatasourceDB {

    override suspend fun addRAtivParada(rAtivParadaModel: RAtivParadaModel): Long {
        return rAtivParadaDao.insert(rAtivParadaModel)
    }

    override suspend fun deleteAllRAtivParada() {
        rAtivParadaDao.deleteAll()
    }

}