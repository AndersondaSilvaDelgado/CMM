package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.ProdutoApi
import br.com.usinasantafe.cmm.features.infra.models.room.stable.ProdutoRoomModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ProdutoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProdutoDatasourceWebServiceImpl @Inject constructor(
    private val produtoApi: ProdutoApi
): ProdutoDatasourceWebService {

    override suspend fun getAllProduto(): Flow<Result<List<ProdutoRoomModel>>> {
        return flow{
            val response = produtoApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}