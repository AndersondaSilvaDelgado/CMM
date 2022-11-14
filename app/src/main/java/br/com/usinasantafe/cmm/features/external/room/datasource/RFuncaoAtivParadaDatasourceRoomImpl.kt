package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.RFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.external.room.dao.RFuncaoAtivParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.RFuncaoAtivParadaDatasourceRoom
import javax.inject.Inject

class RFuncaoAtivParadaDatasourceRoomImpl @Inject constructor (
    private val rFuncaoAtivParadaDao: RFuncaoAtivParadaDao
): RFuncaoAtivParadaDatasourceRoom {

    override suspend fun addRFuncaoAtivParada(rFuncaoAtivParadaModel: RFuncaoAtivParadaModel): Long {
        return rFuncaoAtivParadaDao.insert(rFuncaoAtivParadaModel)
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDao.deleteAll()
    }

}