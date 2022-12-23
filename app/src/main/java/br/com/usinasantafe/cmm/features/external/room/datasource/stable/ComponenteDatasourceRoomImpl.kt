package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ComponenteModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ComponenteDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ComponenteDatasourceRoom
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