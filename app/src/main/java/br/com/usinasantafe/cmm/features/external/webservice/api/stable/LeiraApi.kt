package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_LEIRA
import br.com.usinasantafe.cmm.features.infra.models.room.stable.LeiraRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface LeiraApi {

    @GET(WEB_ALL_LEIRA)
    suspend fun all(): Response<List<LeiraRoomModel>>

}