package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.OSModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface OSApi {

    @GET("os.php")
    suspend fun all(): Response<List<OSModel>>

    @FormUrlEncoded
    @POST("find-os.php")
    suspend fun get(@Field("nroOS") nroOS: String): Response<List<OSModel>>

}