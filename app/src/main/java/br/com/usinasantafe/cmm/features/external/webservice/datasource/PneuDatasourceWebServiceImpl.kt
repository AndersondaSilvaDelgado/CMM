package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.PneuApi
import br.com.usinasantafe.cmm.features.infra.models.stable.PneuModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.PneuDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PneuDatasourceWebServiceImpl @Inject constructor(
    private val pneuApi: PneuApi
): PneuDatasourceWebService {

    override suspend fun getAllPneu(): Flow<Result<List<PneuModel>>> {
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