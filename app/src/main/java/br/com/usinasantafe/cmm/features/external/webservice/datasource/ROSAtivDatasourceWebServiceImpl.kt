package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.ROSAtivApi
import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ROSAtivDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ROSAtivDatasourceWebServiceImpl @Inject constructor(
    private val rOSAtivApi: ROSAtivApi
): ROSAtivDatasourceWebService {

    override suspend fun getAllROSAtiv(): Flow<Result<List<ROSAtivModel>>> {
        return flow{
            val response = rOSAtivApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

    override suspend fun recoverROSAtiv(nroOS: String): Flow<Result<List<ROSAtivModel>>> {
        return flow{
            val response = rOSAtivApi.get(nroOS)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}