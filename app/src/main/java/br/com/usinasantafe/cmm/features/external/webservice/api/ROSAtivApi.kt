package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel
import retrofit2.Response
import retrofit2.http.GET

interface ROSAtivApi {

    @GET("rosativ.php")
    suspend fun all(): Response<List<ROSAtivModel>>

}