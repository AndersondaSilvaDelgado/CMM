package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.ItemOSMecanApi
import br.com.usinasantafe.cmm.features.infra.models.ItemOSMecanModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ItemOSMecanDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemOSMecanDatasourceWebServiceImpl @Inject constructor (
    private val itemOSMecanApi: ItemOSMecanApi
): ItemOSMecanDatasourceWebService {

    override suspend fun getAllItemOSMecan(): Flow<Result<List<ItemOSMecanModel>>> {
        return flow{
            val response = itemOSMecanApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}