package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.RFuncaoAtivParadaRoomModel

interface RFuncaoAtivParadaDatasourceRoom {

    suspend fun addAllRFuncaoAtivParada(vararg rFuncaoAtivParadaRoomModels: RFuncaoAtivParadaRoomModel)

    suspend fun checkImplementoIdAtiv(idAtiv: Long): Boolean

    suspend fun deleteAllRFuncaoAtivParada()

    suspend fun getParadaCheckList(): RFuncaoAtivParadaRoomModel

    suspend fun listRFuncaoAtivIdAtiv(idAtiv: Long): List<RFuncaoAtivParadaRoomModel>

}