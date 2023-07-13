package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.REquipPneuApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.REquipPneuDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipPneuRoomModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class REquipPneuDatasourceWebServiceImpl @Inject constructor(
    private val rEquipPneuApi: REquipPneuApi
): REquipPneuDatasourceWebService {

    override suspend fun getREquipPneu(nroEquip: String): Flow<Result<List<REquipPneuRoomModel>>> {
        return flow{
            val response = rEquipPneuApi.get(nroEquip)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}