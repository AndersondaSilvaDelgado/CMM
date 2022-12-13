package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.TurnoModel
import retrofit2.Response
import retrofit2.http.GET

interface TurnoApi {

    @GET("turno.php")
    suspend fun all(): Response<List<TurnoModel>>

}