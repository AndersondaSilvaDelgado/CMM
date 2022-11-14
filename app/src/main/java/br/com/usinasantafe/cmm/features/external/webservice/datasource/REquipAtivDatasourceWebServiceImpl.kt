package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.REquipAtivApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.REquipAtivDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.REquipAtivModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class REquipAtivDatasourceWebServiceImpl @Inject constructor(
    private val rEquipAtivApi: REquipAtivApi
): REquipAtivDatasourceWebService {

    override suspend fun getREquipAtiv(nroEquip: String): Flow<Result<List<REquipAtivModel>>> {
        return flow{
            val response = rEquipAtivApi.get(nroEquip)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}