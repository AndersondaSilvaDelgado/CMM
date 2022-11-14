package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.RAtivParadaApi
import br.com.usinasantafe.cmm.features.infra.models.RAtivParadaModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.RAtivParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RAtivParadaDatasourceWebServiceImpl @Inject constructor(
    private val rAtivParadaApi: RAtivParadaApi
): RAtivParadaDatasourceWebService {

    override suspend fun getAllRAtivParada(): Flow<Result<List<RAtivParadaModel>>> {
        return flow{
            val response = rAtivParadaApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}