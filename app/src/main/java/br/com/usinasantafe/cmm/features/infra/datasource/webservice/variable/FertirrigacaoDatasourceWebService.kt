package br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable

import br.com.usinasantafe.cmm.features.infra.models.webservice.BoletimFertWebServiceModel


interface FertirrigacaoDatasourceWebService {

    suspend fun sentMotoMec(fertirrigacaoList: List<BoletimFertWebServiceModel>): Result<List<BoletimFertWebServiceModel>>

}