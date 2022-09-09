package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.REquipPneuModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.REquipPneuDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.REquipPneuDatasourceDB
import javax.inject.Inject

class REquipPneuDatasourceDBImpl @Inject constructor (
    private val rEquipPneuDao: REquipPneuDao
): REquipPneuDatasourceDB {

    override suspend fun addREquipPneu(rEquipPneuModel: REquipPneuModel): Long {
        return rEquipPneuDao.insert(rEquipPneuModel)
    }

    override suspend fun deleteAllREquipPneu() {
       rEquipPneuDao.deleteAll()
    }
}