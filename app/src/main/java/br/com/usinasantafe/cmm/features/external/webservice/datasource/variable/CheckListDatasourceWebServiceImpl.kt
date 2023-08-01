package br.com.usinasantafe.cmm.features.external.webservice.datasource.variable

import br.com.usinasantafe.cmm.features.external.webservice.api.variable.CheckListApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.CheckListDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.webservice.CabecCheckListWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.webservice.CabecCheckListWebServiceModelOutput
import javax.inject.Inject

class CheckListDatasourceWebServiceImpl @Inject constructor (
    private val checkListApi: CheckListApi
): CheckListDatasourceWebService {

    override suspend fun sendCheckList(checkListList: List<CabecCheckListWebServiceModelOutput>): Result<List<CabecCheckListWebServiceModelInput>> {
        val response = checkListApi.send(checkListList)
        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Throwable("Erro recebimento de dados"))
        }
    }

}