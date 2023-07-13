package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ComponenteRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ComponenteDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ComponenteDatasourceRoom
import javax.inject.Inject

class ComponenteDatasourceRoomImpl @Inject constructor (
    private val componenteDao: ComponenteDao
): ComponenteDatasourceRoom {

    override suspend fun addAllComponente(vararg componenteRoomModels: ComponenteRoomModel) {
        componenteDao.insertAll(*componenteRoomModels)
    }

    override suspend fun deleteAllComponente() {
        componenteDao.deleteAll()
    }
}