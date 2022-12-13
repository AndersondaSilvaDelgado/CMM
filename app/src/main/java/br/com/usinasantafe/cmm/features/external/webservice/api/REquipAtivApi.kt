package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.REquipAtivModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface REquipAtivApi {

    @FormUrlEncoded
    @POST("find-requipativ.php")
    suspend fun get(@Field("nroEquip") nroEquip: String): Response<List<REquipAtivModel>>
}