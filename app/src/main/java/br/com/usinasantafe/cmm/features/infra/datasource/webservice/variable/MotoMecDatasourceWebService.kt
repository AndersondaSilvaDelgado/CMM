package br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.BoletimMMWebServiceModel

interface MotoMecDatasourceWebService {

    suspend fun sentMotoMec(motoMecList: List<BoletimMMWebServiceModel>): Result<List<BoletimMMWebServiceModel>>

}