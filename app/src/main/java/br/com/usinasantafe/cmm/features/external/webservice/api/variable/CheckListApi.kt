package br.com.usinasantafe.cmm.features.external.webservice.api.variable

import br.com.usinasantafe.cmm.common.utils.WEB_SAVE_CHECK_LIST
import br.com.usinasantafe.cmm.features.infra.models.webservice.CabecCheckListWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.webservice.CabecCheckListWebServiceModelOutput
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CheckListApi {

    @POST(WEB_SAVE_CHECK_LIST)
    suspend fun send(@Body motoMecList: List<CabecCheckListWebServiceModelOutput>): Response<List<CabecCheckListWebServiceModelInput>>

}