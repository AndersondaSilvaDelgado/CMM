package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_FRENTE
import br.com.usinasantafe.cmm.features.infra.models.stable.FrenteModel
import retrofit2.Response
import retrofit2.http.GET

interface FrenteApi {

    @GET(WEB_ALL_FRENTE)
    suspend fun all(): Response<List<FrenteModel>>

}