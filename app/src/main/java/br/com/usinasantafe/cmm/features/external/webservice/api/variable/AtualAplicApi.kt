package br.com.usinasantafe.cmm.features.external.webservice.api.variable

import br.com.usinasantafe.cmm.common.utils.WEB_UPDATE_APP
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.AtualAplicWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.AtualAplicWebServiceModelOutput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AtualAplicApi {

    @POST(WEB_UPDATE_APP)
    suspend fun send(@Body atualAplic: AtualAplicWebServiceModelOutput): Response<AtualAplicWebServiceModelInput>

}