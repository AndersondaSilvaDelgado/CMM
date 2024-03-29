package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.LeiraApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.LeiraRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.LeiraDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LeiraDatasourceWebServiceImpl @Inject constructor(
    private val leiraApi: LeiraApi
): LeiraDatasourceWebService {

    override suspend fun getAllLeira(): Flow<Result<List<LeiraRoomModel>>> {
        return flow{
            val response = leiraApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}