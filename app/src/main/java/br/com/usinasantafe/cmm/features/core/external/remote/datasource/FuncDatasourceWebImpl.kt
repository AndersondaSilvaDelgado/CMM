package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.FuncModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.FuncDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class FuncDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): FuncDatasourceWeb {

    override suspend fun getAllFunc(): List<FuncModel> {
        val funcType = object : TypeToken<List<FuncModel>>() {}.type
        val retorno = responseWeb.getGeneric("func");
        return Gson().fromJson(retorno, funcType)
    }

}