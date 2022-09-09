package br.com.usinasantafe.cmm.features.core.external.database.datasource

import br.com.usinasantafe.cmm.features.core.infra.models.ProdutoModel
import br.com.usinasantafe.cmm.features.core.external.database.dao.ProdutoDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ProdutoDatasourceDB
import javax.inject.Inject

class ProdutoDatasourceDBImpl @Inject constructor (
    private val produtoDao: ProdutoDao
): ProdutoDatasourceDB {

    override suspend fun addProduto(produtoModel: ProdutoModel): Long {
        return produtoDao.insert(produtoModel)
    }

    override suspend fun deleteAllProduto() {
        produtoDao.deleteAll()
    }

}