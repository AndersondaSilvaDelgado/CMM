package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Produto
import br.com.usinasantafe.cmm.features.core.infra.models.toProduto
import br.com.usinasantafe.cmm.features.core.infra.models.toProdutoModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.ProdutoRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ProdutoDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ProdutoDatasourceWeb
import javax.inject.Inject

class ProdutoRepositoryImpl @Inject constructor(
    private val produtoDatasourceDB: ProdutoDatasourceDB,
    private val produtoDatasourceWeb: ProdutoDatasourceWeb
):ProdutoRepository {

    override suspend fun addAllProduto(produtoList: List<Produto>) {
        for(produto in produtoList){
            val produtoModel = produto.toProdutoModel()
            produtoDatasourceDB.addProduto(produtoModel)
        }
    }

    override suspend fun deleteAllProduto() {
        produtoDatasourceDB.deleteAllProduto()
    }

    override suspend fun getAllProduto(): List<Produto> {
        val produtoModelList = produtoDatasourceWeb.getAllProduto()
        val produtoList = mutableListOf<Produto>()
        for (produtoModel in produtoModelList){
            produtoList.add(produtoModel.toProduto())
        }
        return produtoList
    }

}