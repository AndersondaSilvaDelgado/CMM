package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.BocalModel
import retrofit2.Response
import retrofit2.http.GET

interface BocalApi {

    @GET("bocal.php")
    suspend fun all(): Response<List<BocalModel>>

}