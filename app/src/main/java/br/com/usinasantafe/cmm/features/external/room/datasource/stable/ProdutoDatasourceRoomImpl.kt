package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ProdutoRoomModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.ProdutoDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ProdutoDatasourceRoom
import javax.inject.Inject

class ProdutoDatasourceRoomImpl @Inject constructor (
    private val produtoDao: ProdutoDao
): ProdutoDatasourceRoom {

    override suspend fun addAllProduto(vararg produtoRoomModels: ProdutoRoomModel) {
        produtoDao.insertAll(*produtoRoomModels)
    }

    override suspend fun deleteAllProduto() {
        produtoDao.deleteAll()
    }

}