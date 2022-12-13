package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.ItemCheckListModel
import retrofit2.Response
import retrofit2.http.GET

interface ItemCheckListApi {

    @GET("itemchecklist.php")
    suspend fun all(): Response<List<ItemCheckListModel>>

}