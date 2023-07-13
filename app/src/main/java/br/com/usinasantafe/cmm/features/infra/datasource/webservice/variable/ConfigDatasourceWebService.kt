package br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.ConfigWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.ConfigWebServiceModelOutput

interface ConfigDatasourceWebService {
    
    suspend fun sendConfig(config: ConfigWebServiceModelOutput): Result<ConfigWebServiceModelInput>

}