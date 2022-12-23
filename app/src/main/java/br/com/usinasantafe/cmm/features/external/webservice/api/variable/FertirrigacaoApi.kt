package br.com.usinasantafe.cmm.features.external.webservice.api.variable

import br.com.usinasantafe.cmm.common.utils.WEB_SAVE_FERTIRRIGACAO
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.BoletimFertWebServiceModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FertirrigacaoApi {

    @POST(WEB_SAVE_FERTIRRIGACAO)
    suspend fun get(@Body fertirrigacaoList: List<BoletimFertWebServiceModel>): Response<List<BoletimFertWebServiceModel>>

}