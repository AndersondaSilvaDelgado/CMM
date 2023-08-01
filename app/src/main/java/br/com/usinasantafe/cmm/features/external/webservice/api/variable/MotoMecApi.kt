package br.com.usinasantafe.cmm.features.external.webservice.api.variable

import br.com.usinasantafe.cmm.common.utils.WEB_SAVE_MOTOMEC
import br.com.usinasantafe.cmm.features.infra.models.webservice.BoletimMMWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.webservice.BoletimMMWebServiceModelOutput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MotoMecApi {

    @POST(WEB_SAVE_MOTOMEC)
    suspend fun send(@Body motoMecList: List<BoletimMMWebServiceModelOutput>): Response<List<BoletimMMWebServiceModelInput>>

}