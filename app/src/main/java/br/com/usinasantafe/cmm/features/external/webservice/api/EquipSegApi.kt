package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.stable.EquipSegModel
import retrofit2.Response
import retrofit2.http.GET

interface EquipSegApi {

    @GET("equipseg.php")
    suspend fun all(): Response<List<EquipSegModel>>

}