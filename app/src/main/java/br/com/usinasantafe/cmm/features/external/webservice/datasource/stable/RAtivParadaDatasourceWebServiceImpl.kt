package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.RAtivParadaApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.RAtivParadaRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.RAtivParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RAtivParadaDatasourceWebServiceImpl @Inject constructor(
    private val rAtivParadaApi: RAtivParadaApi
): RAtivParadaDatasourceWebService {

    override suspend fun getAllRAtivParada(): Flow<Result<List<RAtivParadaRoomModel>>> {
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