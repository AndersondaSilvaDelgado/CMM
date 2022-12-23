package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_ITEM_OS_MECAN
import br.com.usinasantafe.cmm.features.infra.models.stable.ItemOSMecanModel
import retrofit2.Response
import retrofit2.http.GET

interface ItemOSMecanApi {

    @GET(WEB_ALL_ITEM_OS_MECAN)
    suspend fun all(): Response<List<ItemOSMecanModel>>

}