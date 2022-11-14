package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel
import kotlinx.coroutines.flow.Flow

interface ROSAtivDatasourceWebService {

    suspend fun getAllROSAtiv(): Flow<Result<List<ROSAtivModel>>>

}