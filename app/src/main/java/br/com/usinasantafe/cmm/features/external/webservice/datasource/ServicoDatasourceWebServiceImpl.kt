package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.ServicoApi
import br.com.usinasantafe.cmm.features.infra.models.ServicoModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ServicoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServicoDatasourceWebServiceImpl @Inject constructor(
    private val servicoApi: ServicoApi
): ServicoDatasourceWebService {

    override suspend fun getAllServico(): Flow<Result<List<ServicoModel>>> {
        return flow{
            val response = servicoApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}