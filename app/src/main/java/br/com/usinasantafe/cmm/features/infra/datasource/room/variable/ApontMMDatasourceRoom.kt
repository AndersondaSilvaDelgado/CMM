package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontMMRoomModel

interface ApontMMDatasourceRoom {

    suspend fun insertApontMM(apontMMRoomModel: ApontMMRoomModel): Boolean

    suspend fun listApontIdBol(idBol: Long): List<ApontMMRoomModel>

}