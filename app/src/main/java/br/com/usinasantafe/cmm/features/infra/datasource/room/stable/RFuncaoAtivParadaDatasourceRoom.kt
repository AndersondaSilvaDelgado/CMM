package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.RFuncaoAtivParadaModel

interface RFuncaoAtivParadaDatasourceRoom {

    suspend fun addAllRFuncaoAtivParada(vararg rFuncaoAtivParadaModels: RFuncaoAtivParadaModel)

    suspend fun deleteAllRFuncaoAtivParada()

    suspend fun listRFuncaoAtiv(idAtiv: Long): List<RFuncaoAtivParadaModel>

}