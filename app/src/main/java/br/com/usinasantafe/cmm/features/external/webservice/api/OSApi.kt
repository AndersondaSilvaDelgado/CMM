package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.OSModel
import retrofit2.Response
import retrofit2.http.GET

interface OSApi {

    @GET("os.php")
    suspend fun all(): Response<List<OSModel>>

}