package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.RFuncaoAtivParadaRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.RFuncaoAtivParadaDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.RFuncaoAtivParadaDatasourceRoom
import javax.inject.Inject

class RFuncaoAtivParadaDatasourceRoomImpl @Inject constructor (
    private val rFuncaoAtivParadaDao: RFuncaoAtivParadaDao
): RFuncaoAtivParadaDatasourceRoom {

    override suspend fun addAllRFuncaoAtivParada(vararg rFuncaoAtivParadaRoomModels: RFuncaoAtivParadaRoomModel) {
        rFuncaoAtivParadaDao.insertAll(*rFuncaoAtivParadaRoomModels)
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDao.deleteAll()
    }

    override suspend fun listRFuncaoAtivIdAtiv(idAtiv: Long): List<RFuncaoAtivParadaRoomModel> {
        return rFuncaoAtivParadaDao.listRFuncaoIdAtivTipo(idAtiv, 1L)
    }

    override suspend fun getParadaCheckList(): RFuncaoAtivParadaRoomModel {
        return rFuncaoAtivParadaDao.getRFuncaoAtivParadaCodTipo(1L , 2L)
    }

}