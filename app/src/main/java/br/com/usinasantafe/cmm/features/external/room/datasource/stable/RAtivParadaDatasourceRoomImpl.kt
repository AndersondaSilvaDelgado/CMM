package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.RAtivParadaRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.RAtivParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.RAtivParadaDatasourceRoom
import javax.inject.Inject

class RAtivParadaDatasourceRoomImpl @Inject constructor (
    private val rAtivParadaDao: RAtivParadaDao
): RAtivParadaDatasourceRoom {

    override suspend fun addAllRAtivParada(vararg rAtivParadaRoomModels: RAtivParadaRoomModel) {
        rAtivParadaDao.insertAll(*rAtivParadaRoomModels)
    }

    override suspend fun deleteAllRAtivParada() {
        rAtivParadaDao.deleteAll()
    }

    override suspend fun listRAtivParada(idAtiv: Long): List<RAtivParadaRoomModel> {
        return rAtivParadaDao.listIdAtiv(idAtiv)
    }

}