package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_TURNO
import br.com.usinasantafe.cmm.features.infra.models.room.stable.TurnoRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface TurnoApi {

    @GET(WEB_ALL_TURNO)
    suspend fun all(): Response<List<TurnoRoomModel>>

}