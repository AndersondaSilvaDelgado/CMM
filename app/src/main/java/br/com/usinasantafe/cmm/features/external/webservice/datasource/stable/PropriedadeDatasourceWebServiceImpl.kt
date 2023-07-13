package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.PropriedadeApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.PropriedadeRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.PropriedadeDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PropriedadeDatasourceWebServiceImpl @Inject constructor(
    private val propriedadeApi: PropriedadeApi
): PropriedadeDatasourceWebService {

    override suspend fun getAllPropriedade(): Flow<Result<List<PropriedadeRoomModel>>> {
        return flow{
            val response = propriedadeApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}