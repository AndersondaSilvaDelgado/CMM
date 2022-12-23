package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ProdutoModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ProdutoDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ProdutoDatasourceRoom
import javax.inject.Inject

class ProdutoDatasourceRoomImpl @Inject constructor (
    private val produtoDao: ProdutoDao
): ProdutoDatasourceRoom {

    override suspend fun addAllProduto(vararg produtoModels: ProdutoModel) {
        produtoDao.insertAll(*produtoModels)
    }

    override suspend fun deleteAllProduto() {
        produtoDao.deleteAll()
    }

}