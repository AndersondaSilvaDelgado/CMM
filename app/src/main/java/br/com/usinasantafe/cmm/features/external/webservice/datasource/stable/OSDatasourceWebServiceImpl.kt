package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.OSApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.OSRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.OSDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OSDatasourceWebServiceImpl @Inject constructor(
    private val osApi: OSApi
): OSDatasourceWebService {

    override suspend fun getAllOS(): Flow<Result<List<OSRoomModel>>> {
        return flow{
            val response = osApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

    override suspend fun recoverOS(nroOS: String): Flow<Result<List<OSRoomModel>>> {
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