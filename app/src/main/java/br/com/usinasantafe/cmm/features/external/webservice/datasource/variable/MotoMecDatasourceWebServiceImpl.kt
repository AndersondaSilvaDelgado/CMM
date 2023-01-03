package br.com.usinasantafe.cmm.features.external.webservice.datasource.variable

import br.com.usinasantafe.cmm.features.external.webservice.api.variable.MotoMecApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.MotoMecDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.BoletimMMWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.BoletimMMWebServiceModelOutput
import javax.inject.Inject

class MotoMecDatasourceWebServiceImpl @Inject constructor (
    private val motoMecApi: MotoMecApi
): MotoMecDatasourceWebService {

    override suspend fun sendMotoMec(motoMecList: List<BoletimMMWebServiceModelOutput>): Result<List<BoletimMMWebServiceModelInput>> {
        val response = motoMecApi.send(motoMecList)
        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Throwable("Erro recebimento de dados"))
        }
    }

}