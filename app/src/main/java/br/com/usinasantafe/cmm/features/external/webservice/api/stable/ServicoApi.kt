package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_SERVICO
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ServicoRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface ServicoApi {

    @GET(WEB_ALL_SERVICO)
    suspend fun all(): Response<List<ServicoRoomModel>>

}