package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.RFuncaoAtivParadaModel

interface RFuncaoAtivParadaDatasourceRoom {

    suspend fun addRFuncaoAtivParada(rFuncaoAtivParadaModel: RFuncaoAtivParadaModel): Long

    suspend fun deleteAllRFuncaoAtivParada()

}