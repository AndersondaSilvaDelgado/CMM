package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.RAtivParadaModel
import kotlinx.coroutines.flow.Flow

interface RAtivParadaDatasourceWebService {

    suspend fun getAllRAtivParada(): Flow<Result<List<RAtivParadaModel>>>

}