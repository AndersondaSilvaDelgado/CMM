package br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable

import br.com.usinasantafe.cmm.features.infra.models.webservice.CabecCheckListWebServiceModelInput
import br.com.usinasantafe.cmm.features.infra.models.webservice.CabecCheckListWebServiceModelOutput

interface CheckListDatasourceWebService {

    suspend fun sendCheckList(checkListList: List<CabecCheckListWebServiceModelOutput>): Result<List<CabecCheckListWebServiceModelInput>>

}