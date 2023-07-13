package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.ROSAtivApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ROSAtivRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ROSAtivDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ROSAtivDatasourceWebServiceImpl @Inject constructor(
    private val rOSAtivApi: ROSAtivApi
): ROSAtivDatasourceWebService {

    override suspend fun getAllROSAtiv(): Flow<Result<List<ROSAtivRoomModel>>> {
        return flow{
            val response = rOSAtivApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

    override suspend fun recoverROSAtiv(nroOS: String): Flow<Result<List<ROSAtivRoomModel>>> {
        return flow{
            val response = rOSAtivApi.get(nroOS)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}