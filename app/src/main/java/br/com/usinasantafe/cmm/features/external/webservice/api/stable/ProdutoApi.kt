package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_PRODUTO
import br.com.usinasantafe.cmm.features.infra.models.stable.ProdutoModel
import retrofit2.Response
import retrofit2.http.GET

interface ProdutoApi {

    @GET(WEB_ALL_PRODUTO)
    suspend fun all(): Response<List<ProdutoModel>>

}