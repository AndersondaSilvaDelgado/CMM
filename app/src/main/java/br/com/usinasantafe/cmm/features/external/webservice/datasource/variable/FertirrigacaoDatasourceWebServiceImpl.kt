package br.com.usinasantafe.cmm.features.external.webservice.datasource.variable

import br.com.usinasantafe.cmm.features.external.webservice.api.variable.FertirrigacaoApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.FertirrigacaoDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.webservice.BoletimFertWebServiceModel
import javax.inject.Inject

class FertirrigacaoDatasourceWebServiceImpl @Inject constructor (
    private val fertirrigacaoApi: FertirrigacaoApi
): FertirrigacaoDatasourceWebService {

    override suspend fun sentMotoMec(fertirrigacaoList: List<BoletimFertWebServiceModel>): Result<List<BoletimFertWebServiceModel>> {
        val response = fertirrigacaoApi.get(fertirrigacaoList)
        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Throwable("Erro recebimento de dados"))
        }
    }

}