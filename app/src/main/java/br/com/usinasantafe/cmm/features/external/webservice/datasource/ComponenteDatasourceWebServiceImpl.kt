package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.ComponenteApi
import br.com.usinasantafe.cmm.features.infra.models.ComponenteModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ComponenteDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ComponenteDatasourceWebServiceImpl @Inject constructor(
    private val componenteApi: ComponenteApi
): ComponenteDatasourceWebService {

    override suspend fun getAllComponente(): Flow<Result<List<ComponenteModel>>> {
        return flow{
            val response = componenteApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}