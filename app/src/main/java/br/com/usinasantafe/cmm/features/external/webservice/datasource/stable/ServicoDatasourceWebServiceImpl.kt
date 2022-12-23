package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.ServicoApi
import br.com.usinasantafe.cmm.features.infra.models.stable.ServicoModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ServicoDatasourceWebService
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