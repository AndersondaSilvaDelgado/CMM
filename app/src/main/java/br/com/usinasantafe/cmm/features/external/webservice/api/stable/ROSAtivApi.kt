package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_R_OS_ATIV
import br.com.usinasantafe.cmm.common.utils.WEB_FIELD_NRO_OS
import br.com.usinasantafe.cmm.common.utils.WEB_FIND_R_OS_ATIV
import br.com.usinasantafe.cmm.features.infra.models.stable.ROSAtivModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ROSAtivApi {

    @GET(WEB_ALL_R_OS_ATIV)
    suspend fun all(): Response<List<ROSAtivModel>>

    @FormUrlEncoded
    @POST(WEB_FIND_R_OS_ATIV)
    suspend fun get(@Field(WEB_FIELD_NRO_OS) nroOS: String): Response<List<ROSAtivModel>>

}