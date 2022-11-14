package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.ParadaApi
import br.com.usinasantafe.cmm.features.infra.models.ParadaModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ParadaDatasourceWebServiceImpl @Inject constructor(
    private val paradaApi: ParadaApi
): ParadaDatasourceWebService {

    override suspend fun getAllParada(): Flow<Result<List<ParadaModel>>> {
        return flow{
            val response = paradaApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}