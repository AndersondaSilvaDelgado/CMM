package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.PressaoBocalApi
import br.com.usinasantafe.cmm.features.infra.models.stable.PressaoBocalModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.PressaoBocalDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PressaoBocalDatasourceWebServiceImpl @Inject constructor(
    private val pressaoBocalApi: PressaoBocalApi
): PressaoBocalDatasourceWebService {

    override suspend fun getAllPressaoBocal(): Flow<Result<List<PressaoBocalModel>>> {
        return flow{
            val response = pressaoBocalApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}