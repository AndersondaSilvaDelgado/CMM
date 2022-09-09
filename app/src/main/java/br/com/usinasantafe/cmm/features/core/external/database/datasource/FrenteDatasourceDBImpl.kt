package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.FrenteModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.FrenteDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.FrenteDatasourceDB
import javax.inject.Inject

class FrenteDatasourceDBImpl @Inject constructor (
    private val frenteDao: FrenteDao
): FrenteDatasourceDB {

    override suspend fun addFrente(frenteModel: FrenteModel): Long {
        return frenteDao.insert(frenteModel)
    }

    override suspend fun deleteAllFrente() {
        frenteDao.deleteAll()
    }

}