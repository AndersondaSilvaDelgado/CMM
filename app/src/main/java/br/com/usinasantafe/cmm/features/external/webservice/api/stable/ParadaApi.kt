package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_PARADA
import br.com.usinasantafe.cmm.features.infra.models.stable.ParadaModel
import retrofit2.Response
import retrofit2.http.GET

interface ParadaApi {

    @GET(WEB_ALL_PARADA)
    suspend fun all(): Response<List<ParadaModel>>

}