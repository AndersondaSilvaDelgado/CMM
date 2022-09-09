package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.EquipSegModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.EquipSegDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.EquipSegDatasourceDB
import javax.inject.Inject

class EquipSegDatasourceDBImpl @Inject constructor (
    private val equipSegDao: EquipSegDao
): EquipSegDatasourceDB {

    override suspend fun addEquipSeg(equipSegModel: EquipSegModel): Long {
        return equipSegDao.insert(equipSegModel)
    }

    override suspend fun deleteAllEquipSeg() {
        equipSegDao.deleteAll()
    }

}