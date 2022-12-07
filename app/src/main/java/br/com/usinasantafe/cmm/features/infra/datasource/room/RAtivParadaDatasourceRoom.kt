package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.RAtivParadaModel

interface RAtivParadaDatasourceRoom {

    suspend fun addAllRAtivParada(vararg rAtivParadaModels: RAtivParadaModel)

    suspend fun deleteAllRAtivParada()

}