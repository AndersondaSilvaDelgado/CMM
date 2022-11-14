package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.RFuncaoAtivParadaModel
import retrofit2.Response
import retrofit2.http.GET

interface RFuncaoAtivParadaApi {

    @GET("rfuncaoativparada.php")
    suspend fun all(): Response<List<RFuncaoAtivParadaModel>>

}