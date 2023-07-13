package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.ItemOSMecanApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemOSMecanRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ItemOSMecanDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemOSMecanDatasourceWebServiceImpl @Inject constructor (
    private val itemOSMecanApi: ItemOSMecanApi
): ItemOSMecanDatasourceWebService {

    override suspend fun getAllItemOSMecan(): Flow<Result<List<ItemOSMecanRoomModel>>> {
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