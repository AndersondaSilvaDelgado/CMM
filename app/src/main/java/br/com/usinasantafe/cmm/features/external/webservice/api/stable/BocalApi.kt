package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_BOCAL
import br.com.usinasantafe.cmm.features.infra.models.stable.BocalModel
import retrofit2.Response
import retrofit2.http.GET

interface BocalApi {

    @GET(WEB_ALL_BOCAL)
    suspend fun all(): Response<List<BocalModel>>

}