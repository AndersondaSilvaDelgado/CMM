package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.OSModel
import kotlinx.coroutines.flow.Flow

interface OSDatasourceWebService {

    suspend fun getAllOS(): Flow<Result<List<OSModel>>>

    suspend fun recoverOS(nroOS: String): Flow<Result<List<OSModel>>>

}