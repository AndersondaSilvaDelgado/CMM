package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_PROPRIEDADE
import br.com.usinasantafe.cmm.features.infra.models.stable.PropriedadeModel
import retrofit2.Response
import retrofit2.http.GET

interface PropriedadeApi {

    @GET(WEB_ALL_PROPRIEDADE)
    suspend fun all(): Response<List<PropriedadeModel>>

}