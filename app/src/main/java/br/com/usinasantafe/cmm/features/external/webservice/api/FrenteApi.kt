package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.FrenteModel
import retrofit2.Response
import retrofit2.http.GET

interface FrenteApi {

    @GET("frente.php")
    suspend fun all(): Response<List<FrenteModel>>

}