package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ProdutoModel
import kotlinx.coroutines.flow.Flow

interface ProdutoDatasourceWebService {

   suspend fun getAllProduto(): Flow<Result<List<ProdutoModel>>>

}