package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_ATIVIDADE
import br.com.usinasantafe.cmm.features.infra.models.room.stable.AtividadeRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface AtividadeApi {

    @GET(WEB_ALL_ATIVIDADE)
    suspend fun all(): Response<List<AtividadeRoomModel>>

}