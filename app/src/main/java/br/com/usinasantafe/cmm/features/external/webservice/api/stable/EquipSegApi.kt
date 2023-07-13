package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_EQUIP_SEG
import br.com.usinasantafe.cmm.features.infra.models.room.stable.EquipSegRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface EquipSegApi {

    @GET(WEB_ALL_EQUIP_SEG)
    suspend fun all(): Response<List<EquipSegRoomModel>>

}