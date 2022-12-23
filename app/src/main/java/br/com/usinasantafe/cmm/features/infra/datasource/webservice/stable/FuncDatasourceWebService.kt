package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.FuncModel
import kotlinx.coroutines.flow.Flow

interface FuncDatasourceWebService {

    suspend fun getAllFunc(): Flow<Result<List<FuncModel>>>

}