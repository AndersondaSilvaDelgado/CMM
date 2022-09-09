package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.ComponenteModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.ComponenteDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ComponenteDatasourceDB
import javax.inject.Inject

class ComponenteDatasourceDBImpl @Inject constructor (
    private val componenteDao: ComponenteDao
): ComponenteDatasourceDB {

    override suspend fun addComponente(componenteModel: ComponenteModel): Long {
        return componenteDao.insert(componenteModel)
    }

    override suspend fun deleteAllComponente() {
        componenteDao.deleteAll()
    }
}