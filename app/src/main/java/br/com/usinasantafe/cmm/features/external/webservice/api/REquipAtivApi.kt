package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.REquipAtivModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface REquipAtivApi {

    @FormUrlEncoded
    @POST("requipativ.php")
    suspend fun get(@Field("dado") dado: String): Response<List<REquipAtivModel>>
}