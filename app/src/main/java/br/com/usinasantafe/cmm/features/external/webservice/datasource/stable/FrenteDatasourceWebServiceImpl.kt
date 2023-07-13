package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.FrenteApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.FrenteRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.FrenteDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FrenteDatasourceWebServiceImpl @Inject constructor(
    private val frenteApi: FrenteApi
): FrenteDatasourceWebService {

    override suspend fun getAllFrente(): Flow<Result<List<FrenteRoomModel>>> {
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