package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.LeiraModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.LeiraDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class LeiraDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): LeiraDatasourceWeb {

    override suspend fun getAllLeira(): List<LeiraModel> {
        val leiraType = object : TypeToken<List<LeiraModel>>() {}.type
        val retorno = responseWeb.getGeneric("leira");
        return Gson().fromJson(retorno, leiraType)
    }

}