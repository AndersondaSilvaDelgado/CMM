package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.ProdutoModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ProdutoDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ProdutoDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): ProdutoDatasourceWeb {

    override suspend fun getAllProduto(): List<ProdutoModel> {
        val produtoType = object : TypeToken<List<ProdutoModel>>() {}.type
        val retorno = responseWeb.getGeneric("produto");
        return Gson().fromJson(retorno, produtoType)
    }

}