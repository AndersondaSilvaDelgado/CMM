package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.OSModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.OSDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class OSDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): OSDatasourceWeb {

    override suspend fun getAllOS(): List<OSModel> {
        val osType = object : TypeToken<List<OSModel>>() {}.type
        val retorno = responseWeb.getGeneric("os");
        return Gson().fromJson(retorno, osType)
    }

}