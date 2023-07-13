package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.AtividadeRoomModel

interface AtividadeDatasourceRoom {

    suspend fun addAllAtividade(vararg atividadeRoomModels: AtividadeRoomModel)

    suspend fun deleteAllAtividade()

    suspend fun listInIdAtiv(vararg idAtivs: Long): List<AtividadeRoomModel>

}