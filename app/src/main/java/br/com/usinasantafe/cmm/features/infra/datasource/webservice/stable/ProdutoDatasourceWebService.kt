package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ProdutoRoomModel
import kotlinx.coroutines.flow.Flow

interface ProdutoDatasourceWebService {

   suspend fun getAllProduto(): Flow<Result<List<ProdutoRoomModel>>>

}