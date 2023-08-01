package br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable

import br.com.usinasantafe.cmm.features.infra.models.webservice.BoletimMMWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.webservice.BoletimMMWebServiceModelOutput

interface MotoMecDatasourceWebService {

    suspend fun sendMotoMec(motoMecList: List<BoletimMMWebServiceModelOutput>): Result<List<BoletimMMWebServiceModelInput>>

}