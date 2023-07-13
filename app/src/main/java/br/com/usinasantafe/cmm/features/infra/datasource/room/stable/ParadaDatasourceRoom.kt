package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ParadaRoomModel

interface ParadaDatasourceRoom {

    suspend fun addAllParada(vararg paradaRoomModels: ParadaRoomModel)

    suspend fun deleteAllParada()

    suspend fun listInIdParada(vararg idParadas: Long): List<ParadaRoomModel>

}