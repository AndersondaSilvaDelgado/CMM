package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.MotoMecApi
import br.com.usinasantafe.cmm.features.infra.models.MotoMecModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.MotoMecDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MotoMecDatasourceWebServiceImpl @Inject constructor(
    private val motoMecApi: MotoMecApi
): MotoMecDatasourceWebService {

    override suspend fun getAllMotoMec(): Flow<Result<List<MotoMecModel>>> {
        return flow{
            val response = motoMecApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}