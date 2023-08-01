package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.room.variable.ApontMMRoomModel

interface ApontMMDatasourceRoom {

    suspend fun checkApontMMSend(): Boolean

    suspend fun insertApontMM(apontMMRoomModel: ApontMMRoomModel): Boolean

    suspend fun deleteApontMM(apontMMRoomModel: ApontMMRoomModel): Boolean

    suspend fun listApontIdBolStatusSend(idBol: Long): List<ApontMMRoomModel>

    suspend fun listApontIdBolStatusEnviado(idBol: Long): List<ApontMMRoomModel>

    suspend fun updateApontMMSent(apontMMRoomModel: ApontMMRoomModel): Boolean

}