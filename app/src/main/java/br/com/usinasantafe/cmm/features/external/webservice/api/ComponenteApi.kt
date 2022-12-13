package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.ComponenteModel
import retrofit2.Response
import retrofit2.http.GET

interface ComponenteApi {

    @GET("componente.php")
    suspend fun all(): Response<List<ComponenteModel>>

}