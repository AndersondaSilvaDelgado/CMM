package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.PressaoBocalModel
import retrofit2.Response
import retrofit2.http.GET

interface PressaoBocalApi {

    @GET("pressaobocal.php")
    suspend fun all(): Response<List<PressaoBocalModel>>

}