package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.PneuModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.PneuDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.PneuDatasourceDB
import javax.inject.Inject

class PneuDatasourceDBImpl @Inject constructor(
    private val pneuDao: PneuDao
): PneuDatasourceDB {

    override suspend fun addPneu(pneuModel: PneuModel): Long {
        return pneuDao.insert(pneuModel)
    }

    override suspend fun deleteAllPneu() {
        pneuDao.deleteAll()
    }
}