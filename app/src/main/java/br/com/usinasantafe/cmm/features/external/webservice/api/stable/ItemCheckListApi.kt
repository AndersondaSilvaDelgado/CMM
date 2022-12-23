package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_ITEM_CHECKLIST
import br.com.usinasantafe.cmm.features.infra.models.stable.ItemCheckListModel
import retrofit2.Response
import retrofit2.http.GET

interface ItemCheckListApi {

    @GET(WEB_ALL_ITEM_CHECKLIST)
    suspend fun all(): Response<List<ItemCheckListModel>>

}