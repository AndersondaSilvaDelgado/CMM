package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.PneuApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.PneuRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.PneuDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PneuDatasourceWebServiceImpl @Inject constructor(
    private val pneuApi: PneuApi
): PneuDatasourceWebService {

    override suspend fun getAllPneu(): Flow<Result<List<PneuRoomModel>>> {
        return flow{
            val response = pneuApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}