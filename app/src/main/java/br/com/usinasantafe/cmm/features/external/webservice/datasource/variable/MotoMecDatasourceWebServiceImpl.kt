package br.com.usinasantafe.cmm.features.external.webservice.datasource.variable

import br.com.usinasantafe.cmm.features.external.webservice.api.variable.MotoMecApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.MotoMecDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.BoletimMMWebServiceModel
import javax.inject.Inject

class MotoMecDatasourceWebServiceImpl @Inject constructor (
    private val motoMecApi: MotoMecApi
): MotoMecDatasourceWebService {

    override suspend fun sentMotoMec(motoMecList: List<BoletimMMWebServiceModel>): Result<List<BoletimMMWebServiceModel>> {
        val response = motoMecApi.get(motoMecList)
        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Throwable("Erro recebimento de dados"))
        }
    }

}