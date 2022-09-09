package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.PressaoBocalModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.PressaoBocalDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.PressaoBocalDatasourceDB
import javax.inject.Inject

class PressaoBocalDatasourceDBImpl @Inject constructor (
    private val pressaoBocalDao: PressaoBocalDao
): PressaoBocalDatasourceDB {

    override suspend fun addPressaoBocal(pressaoBocalModel: PressaoBocalModel): Long {
        return pressaoBocalDao.insert(pressaoBocalModel)
    }

    override suspend fun deleteAllPressaoBocal() {
        pressaoBocalDao.deleteAll()
    }

}