package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.RAtivParadaModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.RAtivParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.RAtivParadaDatasourceRoom
import javax.inject.Inject

class RAtivParadaDatasourceRoomImpl @Inject constructor (
    private val rAtivParadaDao: RAtivParadaDao
): RAtivParadaDatasourceRoom {

    override suspend fun addAllRAtivParada(vararg rAtivParadaModels: RAtivParadaModel) {
        rAtivParadaDao.insertAll(*rAtivParadaModels)
    }

    override suspend fun deleteAllRAtivParada() {
        rAtivParadaDao.deleteAll()
    }

}