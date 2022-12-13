package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.PropriedadeApi
import br.com.usinasantafe.cmm.features.infra.models.stable.PropriedadeModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.PropriedadeDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PropriedadeDatasourceWebServiceImpl @Inject constructor(
    private val propriedadeApi: PropriedadeApi
): PropriedadeDatasourceWebService {

    override suspend fun getAllPropriedade(): Flow<Result<List<PropriedadeModel>>> {
        return flow{
            val response = propriedadeApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}