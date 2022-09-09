package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.ParadaModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.ParadaDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ParadaDatasourceDB
import javax.inject.Inject

class ParadaDatasourceDBImpl @Inject constructor (
    private val paradaDao: ParadaDao
): ParadaDatasourceDB {

    override suspend fun addParada(paradaModel: ParadaModel): Long {
        return paradaDao.insert(paradaModel)
    }

    override suspend fun deleteAllParada() {
        paradaDao.deleteAll()
    }

}