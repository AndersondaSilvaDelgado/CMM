package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.LeiraModel
import retrofit2.Response
import retrofit2.http.GET

interface LeiraApi {

    @GET("leira.php")
    suspend fun all(): Response<List<LeiraModel>>

}