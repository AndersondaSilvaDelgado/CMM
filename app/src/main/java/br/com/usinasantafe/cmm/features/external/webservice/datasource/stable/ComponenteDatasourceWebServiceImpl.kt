package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.ComponenteApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ComponenteRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ComponenteDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ComponenteDatasourceWebServiceImpl @Inject constructor(
    private val componenteApi: ComponenteApi
): ComponenteDatasourceWebService {

    override suspend fun getAllComponente(): Flow<Result<List<ComponenteRoomModel>>> {
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