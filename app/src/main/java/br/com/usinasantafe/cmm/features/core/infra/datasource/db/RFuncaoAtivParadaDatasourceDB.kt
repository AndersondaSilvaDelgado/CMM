package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.RFuncaoAtivParadaModel

interface RFuncaoAtivParadaDatasourceDB {

    suspend fun addRFuncaoAtivParada(rFuncaoAtivParadaModel: RFuncaoAtivParadaModel): Long

    suspend fun deleteAllRFuncaoAtivParada()

}