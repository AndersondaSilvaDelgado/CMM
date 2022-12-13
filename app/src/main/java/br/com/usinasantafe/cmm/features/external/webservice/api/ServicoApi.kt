package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.ServicoModel
import retrofit2.Response
import retrofit2.http.GET

interface ServicoApi {

    @GET("servico.php")
    suspend fun all(): Response<List<ServicoModel>>

}