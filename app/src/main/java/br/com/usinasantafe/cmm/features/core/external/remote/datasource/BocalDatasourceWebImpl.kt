package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.BocalModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.BocalDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class BocalDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): BocalDatasourceWeb {

    override suspend fun getAllBocal(): List<BocalModel> {
        val bocalType = object : TypeToken<List<BocalModel>>() {}.type
        val retorno = responseWeb.getGeneric("bocal");
        return Gson().fromJson(retorno, bocalType)
    }

}