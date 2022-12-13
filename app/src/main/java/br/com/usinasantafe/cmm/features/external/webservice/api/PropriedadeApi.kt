package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.PropriedadeModel
import retrofit2.Response
import retrofit2.http.GET

interface PropriedadeApi {

    @GET("propriedade.php")
    suspend fun all(): Response<List<PropriedadeModel>>

}