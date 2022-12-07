package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.RFuncaoAtivParadaModel

interface RFuncaoAtivParadaDatasourceRoom {

    suspend fun addAllRFuncaoAtivParada(vararg rFuncaoAtivParadaModels: RFuncaoAtivParadaModel)

    suspend fun deleteAllRFuncaoAtivParada()

}