package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.RAtivParadaModel
import br.com.usinasantafe.cmm.features.external.room.dao.RAtivParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.RAtivParadaDatasourceRoom
import javax.inject.Inject

class RAtivParadaDatasourceRoomImpl @Inject constructor (
    private val rAtivParadaDao: RAtivParadaDao
): RAtivParadaDatasourceRoom {

    override suspend fun addRAtivParada(rAtivParadaModel: RAtivParadaModel): Long {
        return rAtivParadaDao.insert(rAtivParadaModel)
    }

    override suspend fun deleteAllRAtivParada() {
        rAtivParadaDao.deleteAll()
    }

}