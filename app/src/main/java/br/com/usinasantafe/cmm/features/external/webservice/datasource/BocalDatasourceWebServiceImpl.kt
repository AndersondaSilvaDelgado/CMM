package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.BocalApi
import br.com.usinasantafe.cmm.features.infra.models.stable.BocalModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.BocalDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BocalDatasourceWebServiceImpl @Inject constructor(
    private val bocalApi: BocalApi
): BocalDatasourceWebService {

    override suspend fun getAllBocal(): Flow<Result<List<BocalModel>>> {
        return flow{
            val response = bocalApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}