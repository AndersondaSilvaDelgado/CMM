package br.com.usinasantafe.cmm.features.external.webservice.datasource

import br.com.usinasantafe.cmm.features.external.webservice.api.ProdutoApi
import br.com.usinasantafe.cmm.features.infra.models.stable.ProdutoModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ProdutoDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProdutoDatasourceWebServiceImpl @Inject constructor(
    private val produtoApi: ProdutoApi
): ProdutoDatasourceWebService {

    override suspend fun getAllProduto(): Flow<Result<List<ProdutoModel>>> {
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