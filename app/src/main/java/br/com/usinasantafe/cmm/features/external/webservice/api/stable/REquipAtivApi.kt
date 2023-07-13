package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_FIELD_NRO_EQUIP
import br.com.usinasantafe.cmm.common.utils.WEB_FIND_R_EQUIP_ATIV
import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipAtivRoomModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface REquipAtivApi {

    @FormUrlEncoded
    @POST(WEB_FIND_R_EQUIP_ATIV)
    suspend fun get(@Field(WEB_FIELD_NRO_EQUIP) nroEquip: String): Response<List<REquipAtivRoomModel>>
}