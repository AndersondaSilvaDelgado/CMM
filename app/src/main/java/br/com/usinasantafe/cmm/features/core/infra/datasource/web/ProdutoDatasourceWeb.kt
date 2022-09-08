package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.ProdutoModel

interface ProdutoDatasourceWeb {

   suspend fun getAllProduto(): List<ProdutoModel>

}