package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.AtividadeModel
import retrofit2.Response
import retrofit2.http.GET

interface AtividadeApi {

    @GET("atividade.php")
    suspend fun all(): Response<List<AtividadeModel>>

}