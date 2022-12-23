package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_FIELD_NRO_EQUIP
import br.com.usinasantafe.cmm.common.utils.WEB_FIND_EQUIP
import br.com.usinasantafe.cmm.features.infra.models.stable.EquipModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EquipApi {

    @FormUrlEncoded
    @POST(WEB_FIND_EQUIP)
    suspend fun get(@Field(WEB_FIELD_NRO_EQUIP) nroEquip: String): Response<List<EquipModel>>

}