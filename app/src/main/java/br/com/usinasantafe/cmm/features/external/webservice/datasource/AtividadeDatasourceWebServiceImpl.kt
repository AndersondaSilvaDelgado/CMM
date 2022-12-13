package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.AtividadeApi
import br.com.usinasantafe.cmm.features.infra.models.stable.AtividadeModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.AtividadeDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AtividadeDatasourceWebServiceImpl @Inject constructor (
    private val atividadeApi: AtividadeApi
): AtividadeDatasourceWebService {

    override suspend fun getAllAtividade(): Flow<Result<List<AtividadeModel>>> {
        return flow{
            val response = atividadeApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }

        }
    }

}