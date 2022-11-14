package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.RFuncaoAtivParadaApi
import br.com.usinasantafe.cmm.features.infra.models.RFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.RFuncaoAtivParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RFuncaoAtivParadaDatasourceWebServiceImpl @Inject constructor(
    private val rFuncaoAtivParadaApi: RFuncaoAtivParadaApi
): RFuncaoAtivParadaDatasourceWebService {

    override suspend fun getAllRFuncaoAtivParada(): Flow<Result<List<RFuncaoAtivParadaModel>>> {
        return flow{
            val response = rFuncaoAtivParadaApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}