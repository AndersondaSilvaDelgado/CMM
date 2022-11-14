package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.EquipApi
import br.com.usinasantafe.cmm.features.infra.models.EquipModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.EquipDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EquipDatasourceWebServiceImpl @Inject constructor(
    private val equipApi: EquipApi
): EquipDatasourceWebService {

    override suspend fun getEquip(nroEquip: String): Flow<Result<List<EquipModel>>> {
        return flow{
            val response = equipApi.get(nroEquip)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}