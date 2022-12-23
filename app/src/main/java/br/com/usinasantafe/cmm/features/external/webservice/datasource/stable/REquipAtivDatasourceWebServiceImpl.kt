package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.REquipAtivApi
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.REquipAtivDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.stable.REquipAtivModel
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