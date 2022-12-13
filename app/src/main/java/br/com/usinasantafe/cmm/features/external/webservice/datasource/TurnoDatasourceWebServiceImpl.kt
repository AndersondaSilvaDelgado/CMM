package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.TurnoApi
import br.com.usinasantafe.cmm.features.infra.models.stable.TurnoModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.TurnoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TurnoDatasourceWebServiceImpl @Inject constructor(
    private val turnoApi: TurnoApi
): TurnoDatasourceWebService {

    override suspend fun getAllTurno(): Flow<Result<List<TurnoModel>>> {
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