package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.RAtivParadaRoomModel

interface RAtivParadaDatasourceRoom {

    suspend fun addAllRAtivParada(vararg rAtivParadaRoomModels: RAtivParadaRoomModel)

    suspend fun deleteAllRAtivParada()

    suspend fun listRAtivParada(idAtiv: Long): List<RAtivParadaRoomModel>

}