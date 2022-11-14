package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.REquipPneuApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.REquipPneuDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.REquipPneuModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class REquipPneuDatasourceWebServiceImpl @Inject constructor(
    private val rEquipPneuApi: REquipPneuApi
): REquipPneuDatasourceWebService {

    override suspend fun getREquipPneu(nroEquip: String): Flow<Result<List<REquipPneuModel>>> {
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