package br.com.usinasantafe.cmm.features.infra.datasource.webservice

import br.com.usinasantafe.cmm.features.infra.models.FuncModel
import kotlinx.coroutines.flow.Flow

interface FuncDatasourceWebService {

    suspend fun getAllFunc(): Flow<Result<List<FuncModel>>>

}