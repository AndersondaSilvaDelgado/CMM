package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.ProdutoModel
import br.com.usinasantafe.cmm.features.external.room.dao.ProdutoDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.ProdutoDatasourceRoom
import javax.inject.Inject

class ProdutoDatasourceRoomImpl @Inject constructor (
    private val produtoDao: ProdutoDao
): ProdutoDatasourceRoom {

    override suspend fun addProduto(produtoModel: ProdutoModel): Long {
        return produtoDao.insert(produtoModel)
    }

    override suspend fun deleteAllProduto() {
        produtoDao.deleteAll()
    }

}