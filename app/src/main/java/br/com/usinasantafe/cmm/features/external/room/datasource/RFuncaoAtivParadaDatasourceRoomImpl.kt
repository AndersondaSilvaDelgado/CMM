package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.RFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.external.room.dao.RFuncaoAtivParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.RFuncaoAtivParadaDatasourceRoom
import javax.inject.Inject

class RFuncaoAtivParadaDatasourceRoomImpl @Inject constructor (
    private val rFuncaoAtivParadaDao: RFuncaoAtivParadaDao
): RFuncaoAtivParadaDatasourceRoom {

    override suspend fun addAllRFuncaoAtivParada(vararg rFuncaoAtivParadaModels: RFuncaoAtivParadaModel) {
        rFuncaoAtivParadaDao.insertAll(*rFuncaoAtivParadaModels)
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDao.deleteAll()
    }

}