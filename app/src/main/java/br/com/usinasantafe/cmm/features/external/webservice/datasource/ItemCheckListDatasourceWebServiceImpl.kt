package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.ItemCheckListApi
import br.com.usinasantafe.cmm.features.infra.models.ItemCheckListModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ItemCheckListDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemCheckListDatasourceWebServiceImpl @Inject constructor(
    private val itemCheckListApi: ItemCheckListApi
): ItemCheckListDatasourceWebService {

    override suspend fun getAllItemCheckList(): Flow<Result<List<ItemCheckListModel>>> {
        return flow{
            val response = itemCheckListApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}