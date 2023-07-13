package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.TurnoApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.TurnoRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.TurnoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TurnoDatasourceWebServiceImpl @Inject constructor(
    private val turnoApi: TurnoApi
): TurnoDatasourceWebService {

    override suspend fun getAllTurno(): Flow<Result<List<TurnoRoomModel>>> {
        return flow{
            val response = turnoApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}