package br.com.usinasantafe.cmm.features.external.webservice.api.stable

import br.com.usinasantafe.cmm.common.utils.WEB_ALL_OPER_MOTOMEC
import br.com.usinasantafe.cmm.features.infra.models.stable.OperMotoMecModel
import retrofit2.Response
import retrofit2.http.GET

interface OperMotoMecApi {

    @GET(WEB_ALL_OPER_MOTOMEC)
    suspend fun all(): Response<List<OperMotoMecModel>>

}