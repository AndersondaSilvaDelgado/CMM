package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.OperMotoMecApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.OperMotoMecRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.OperMotoMecDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OperMotoMecDatasourceWebServiceImpl @Inject constructor(
    private val operMotoMecApi: OperMotoMecApi
): OperMotoMecDatasourceWebService {

    override suspend fun getAllOperMotoMec(): Flow<Result<List<OperMotoMecRoomModel>>> {
        return flow{
            val response = operMotoMecApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}