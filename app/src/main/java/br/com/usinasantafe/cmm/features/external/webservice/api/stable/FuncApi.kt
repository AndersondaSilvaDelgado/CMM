package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_FUNC
import br.com.usinasantafe.cmm.features.infra.models.room.stable.FuncRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface FuncApi {

    @GET(WEB_ALL_FUNC)
    suspend fun all(): Response<List<FuncRoomModel>>

}