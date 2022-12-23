package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.RFuncaoAtivParadaModel
import kotlinx.coroutines.flow.Flow

interface RFuncaoAtivParadaDatasourceWebService {

    suspend fun getAllRFuncaoAtivParada(): Flow<Result<List<RFuncaoAtivParadaModel>>>

}