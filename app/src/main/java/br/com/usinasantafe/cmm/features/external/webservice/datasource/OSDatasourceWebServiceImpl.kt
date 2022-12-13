package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.OSApi
import br.com.usinasantafe.cmm.features.infra.models.stable.OSModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.OSDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OSDatasourceWebServiceImpl @Inject constructor(
    private val osApi: OSApi
): OSDatasourceWebService {

    override suspend fun getAllOS(): Flow<Result<List<OSModel>>> {
        return flow{
            val response = osApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

    override suspend fun recoverOS(nroOS: String): Flow<Result<List<OSModel>>> {
        return flow{
            val response = osApi.get(nroOS)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}