package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.ComponenteModel
import br.com.usinasantafe.cmm.features.external.room.dao.ComponenteDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ComponenteDatasourceRoom
import javax.inject.Inject

class ComponenteDatasourceRoomImpl @Inject constructor (
    private val componenteDao: ComponenteDao
): ComponenteDatasourceRoom {

    override suspend fun addAllComponente(vararg componenteModels: ComponenteModel) {
        componenteDao.insertAll(*componenteModels)
    }

    override suspend fun deleteAllComponente() {
        componenteDao.deleteAll()
    }
}