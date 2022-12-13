package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.FrenteApi
import br.com.usinasantafe.cmm.features.infra.models.stable.FrenteModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.FrenteDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FrenteDatasourceWebServiceImpl @Inject constructor(
    private val frenteApi: FrenteApi
): FrenteDatasourceWebService {

    override suspend fun getAllFrente(): Flow<Result<List<FrenteModel>>> {
        return flow{
            val response = frenteApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}