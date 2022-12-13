package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.EquipModel
import br.com.usinasantafe.cmm.features.infra.models.stable.ROSAtivModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ROSAtivApi {

    @GET("rosativ.php")
    suspend fun all(): Response<List<ROSAtivModel>>

    @FormUrlEncoded
    @POST("find-rosativ.php")
    suspend fun get(@Field("nroOS") nrooS: String): Response<List<ROSAtivModel>>

}