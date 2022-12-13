package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.FuncModel
import retrofit2.Response
import retrofit2.http.GET

interface FuncApi {

    @GET("func.php")
    suspend fun all(): Response<List<FuncModel>>

}