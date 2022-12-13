package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.ItemOSMecanModel
import retrofit2.Response
import retrofit2.http.GET

interface ItemOSMecanApi {

    @GET("itemosmecan.php")
    suspend fun all(): Response<List<ItemOSMecanModel>>

}