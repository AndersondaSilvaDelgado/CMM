package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_PRESSAO_BOCAL
import br.com.usinasantafe.cmm.features.infra.models.room.stable.PressaoBocalRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface PressaoBocalApi {

    @GET(WEB_ALL_PRESSAO_BOCAL)
    suspend fun all(): Response<List<PressaoBocalRoomModel>>

}