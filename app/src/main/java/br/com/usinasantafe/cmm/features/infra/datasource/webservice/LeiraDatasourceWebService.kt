package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.LeiraModel
import kotlinx.coroutines.flow.Flow

interface LeiraDatasourceWebService {

    suspend fun getAllLeira(): Flow<Result<List<LeiraModel>>>

}