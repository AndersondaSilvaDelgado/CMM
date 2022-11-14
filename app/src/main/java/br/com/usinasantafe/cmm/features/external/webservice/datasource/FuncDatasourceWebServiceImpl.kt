package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.FuncApi
import br.com.usinasantafe.cmm.features.infra.models.FuncModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.FuncDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FuncDatasourceWebServiceImpl @Inject constructor(
    private val funcApi: FuncApi
): FuncDatasourceWebService {

    override suspend fun getAllFunc(): Flow<Result<List<FuncModel>>> {
        return flow{
            val response = funcApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}