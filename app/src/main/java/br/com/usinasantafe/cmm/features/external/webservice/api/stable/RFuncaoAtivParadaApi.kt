package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_R_FUNCAO_ATIV_PARADA
import br.com.usinasantafe.cmm.features.infra.models.room.stable.RFuncaoAtivParadaRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface RFuncaoAtivParadaApi {

    @GET(WEB_ALL_R_FUNCAO_ATIV_PARADA)
    suspend fun all(): Response<List<RFuncaoAtivParadaRoomModel>>

}