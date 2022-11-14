package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.ProdutoModel
import retrofit2.Response
import retrofit2.http.GET

interface ProdutoApi {

    @GET("produto.php")
    suspend fun all(): Response<List<ProdutoModel>>

}