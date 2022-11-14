package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.MotoMecModel
import retrofit2.Response
import retrofit2.http.GET

interface MotoMecApi {

    @GET("motomec.php")
    suspend fun all(): Response<List<MotoMecModel>>

}