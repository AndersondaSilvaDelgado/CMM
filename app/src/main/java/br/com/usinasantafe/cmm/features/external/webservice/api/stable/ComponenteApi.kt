package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_COMPONENTE
import br.com.usinasantafe.cmm.features.infra.models.stable.ComponenteModel
import retrofit2.Response
import retrofit2.http.GET

interface ComponenteApi {

    @GET(WEB_ALL_COMPONENTE)
    suspend fun all(): Response<List<ComponenteModel>>

}