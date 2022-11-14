package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.RAtivParadaModel
import retrofit2.Response
import retrofit2.http.GET

interface RAtivParadaApi {

    @GET("rativparada.php")
    suspend fun all(): Response<List<RAtivParadaModel>>

}