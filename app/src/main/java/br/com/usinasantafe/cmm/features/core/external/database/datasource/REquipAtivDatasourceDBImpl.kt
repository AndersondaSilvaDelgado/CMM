package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.REquipAtivModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.REquipAtivDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.REquipAtivDatasourceDB
import javax.inject.Inject

class REquipAtivDatasourceDBImpl @Inject constructor (
    private val rEquipAtivDao: REquipAtivDao
): REquipAtivDatasourceDB {

    override suspend fun addREquipAtiv(rEquipAtivModel: REquipAtivModel): Long {
        return rEquipAtivDao.insert(rEquipAtivModel)
    }

    override suspend fun deleteAllREquipAtiv() {
        rEquipAtivDao.deleteAll()
    }

}