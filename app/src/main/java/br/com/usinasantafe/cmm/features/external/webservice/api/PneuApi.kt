package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.PneuModel
import retrofit2.Response
import retrofit2.http.GET

interface PneuApi {

    @GET("pneu.php")
    suspend fun all(): Response<List<PneuModel>>

}