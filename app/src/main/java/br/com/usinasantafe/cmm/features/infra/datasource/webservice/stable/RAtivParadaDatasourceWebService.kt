package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.RAtivParadaModel
import kotlinx.coroutines.flow.Flow

interface RAtivParadaDatasourceWebService {

    suspend fun getAllRAtivParada(): Flow<Result<List<RAtivParadaModel>>>

}