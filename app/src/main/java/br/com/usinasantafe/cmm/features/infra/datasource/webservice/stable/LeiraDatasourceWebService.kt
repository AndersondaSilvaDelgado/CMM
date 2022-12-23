package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.LeiraModel
import kotlinx.coroutines.flow.Flow

interface LeiraDatasourceWebService {

    suspend fun getAllLeira(): Flow<Result<List<LeiraModel>>>

}