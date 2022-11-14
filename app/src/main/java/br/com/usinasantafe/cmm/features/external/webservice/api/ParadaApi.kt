package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.ParadaModel
import retrofit2.Response
import retrofit2.http.GET

interface ParadaApi {

    @GET("parada.php")
    suspend fun all(): Response<List<ParadaModel>>

}