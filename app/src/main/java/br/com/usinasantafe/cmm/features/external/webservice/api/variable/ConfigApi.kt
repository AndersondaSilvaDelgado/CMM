package br.com.usinasantafe.cmm.features.external.webservice.api.variable

import br.com.usinasantafe.cmm.common.utils.WEB_UPDATE_APP
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.ConfigWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.ConfigWebServiceModelOutput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ConfigApi {

    @POST(WEB_UPDATE_APP)
    suspend fun send(@Body config: ConfigWebServiceModelOutput): Response<ConfigWebServiceModelInput>

}