package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.FrenteModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.FrenteDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class FrenteDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): FrenteDatasourceWeb {

    override suspend fun getAllFrente(): List<FrenteModel> {
        val frenteType = object : TypeToken<List<FrenteModel>>() {}.type
        val retorno = responseWeb.getGeneric("frente");
        return Gson().fromJson(retorno, frenteType)
    }

}