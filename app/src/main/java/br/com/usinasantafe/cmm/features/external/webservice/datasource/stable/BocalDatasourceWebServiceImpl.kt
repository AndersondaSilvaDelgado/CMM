package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.BocalApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.BocalRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.BocalDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BocalDatasourceWebServiceImpl @Inject constructor(
    private val bocalApi: BocalApi
): BocalDatasourceWebService {

    override suspend fun getAllBocal(): Flow<Result<List<BocalRoomModel>>> {
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