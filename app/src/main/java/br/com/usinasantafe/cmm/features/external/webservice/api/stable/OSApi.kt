package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_OS
import br.com.usinasantafe.cmm.common.utils.WEB_FIELD_NRO_OS
import br.com.usinasantafe.cmm.common.utils.WEB_FIND_OS
import br.com.usinasantafe.cmm.features.infra.models.stable.OSModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface OSApi {

    @GET(WEB_ALL_OS)
    suspend fun all(): Response<List<OSModel>>

    @FormUrlEncoded
    @POST(WEB_FIND_OS)
    suspend fun get(@Field(WEB_FIELD_NRO_OS) nroOS: String): Response<List<OSModel>>

}