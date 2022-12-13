package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.stable.OSModel
import br.com.usinasantafe.cmm.features.infra.models.stable.ROSAtivModel
import kotlinx.coroutines.flow.Flow

interface ROSAtivDatasourceWebService {

    suspend fun getAllROSAtiv(): Flow<Result<List<ROSAtivModel>>>

    suspend fun recoverROSAtiv(nroOS: String): Flow<Result<List<ROSAtivModel>>>

}