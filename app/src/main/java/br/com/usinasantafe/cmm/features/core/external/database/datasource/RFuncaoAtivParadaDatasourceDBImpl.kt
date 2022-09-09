package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.RFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.RFuncaoAtivParadaDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.RFuncaoAtivParadaDatasourceDB
import javax.inject.Inject

class RFuncaoAtivParadaDatasourceDBImpl @Inject constructor (
    private val rFuncaoAtivParadaDao: RFuncaoAtivParadaDao
): RFuncaoAtivParadaDatasourceDB {

    override suspend fun addRFuncaoAtivParada(rFuncaoAtivParadaModel: RFuncaoAtivParadaModel): Long {
        return rFuncaoAtivParadaDao.insert(rFuncaoAtivParadaModel)
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDao.deleteAll()
    }

}