package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_R_ATIV_PARADA
import br.com.usinasantafe.cmm.features.infra.models.room.stable.RAtivParadaRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface RAtivParadaApi {

    @GET(WEB_ALL_R_ATIV_PARADA)
    suspend fun all(): Response<List<RAtivParadaRoomModel>>

}