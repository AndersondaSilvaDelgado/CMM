package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.RAtivParadaModel

interface RAtivParadaDatasourceRoom {

    suspend fun addAllRAtivParada(vararg rAtivParadaModels: RAtivParadaModel)

    suspend fun deleteAllRAtivParada()

    suspend fun listRAtivParada(idAtiv: Long): List<RAtivParadaModel>

}