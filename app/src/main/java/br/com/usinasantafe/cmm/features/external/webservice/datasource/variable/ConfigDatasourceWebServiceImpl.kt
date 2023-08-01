package br.com.usinasantafe.cmm.features.external.webservice.datasource.variable

import br.com.usinasantafe.cmm.features.external.webservice.api.variable.ConfigApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.ConfigDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.webservice.ConfigWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.webservice.ConfigWebServiceModelOutput
import javax.inject.Inject

class ConfigDatasourceWebServiceImpl @Inject constructor (
    private val configApi: ConfigApi
): ConfigDatasourceWebService {

    override suspend fun sendConfig(config: ConfigWebServiceModelOutput): Result<ConfigWebServiceModelInput> {
        val response = configApi.send(config)
        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Throwable("Erro recebimento de dados"))
        }
    }

}