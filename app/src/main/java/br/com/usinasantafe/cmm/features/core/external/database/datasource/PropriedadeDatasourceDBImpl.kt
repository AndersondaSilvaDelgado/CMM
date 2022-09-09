package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.PropriedadeModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.PropriedadeDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.PropriedadeDatasourceDB
import javax.inject.Inject

class PropriedadeDatasourceDBImpl @Inject constructor (
    private val propriedadeDao: PropriedadeDao
): PropriedadeDatasourceDB {

    override suspend fun addPropriedade(propriedadeModel: PropriedadeModel): Long {
        return propriedadeDao.insert(propriedadeModel)
    }

    override suspend fun deleteAllPropriedade() {
        propriedadeDao.deleteAll()
    }

}