package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_PNEU
import br.com.usinasantafe.cmm.features.infra.models.stable.PneuModel
import retrofit2.Response
import retrofit2.http.GET

interface PneuApi {

    @GET(WEB_ALL_PNEU)
    suspend fun all(): Response<List<PneuModel>>

}