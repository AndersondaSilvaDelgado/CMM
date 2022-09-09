package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.RAtivParadaModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.RAtivParadaDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class RAtivParadaDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): RAtivParadaDatasourceWeb {

    override suspend fun getAllRAtivParada(): List<RAtivParadaModel> {
        val rAtivParadaType = object : TypeToken<List<RAtivParadaModel>>() {}.type
        val retorno = responseWeb.getGeneric("rativparada");
        return Gson().fromJson(retorno, rAtivParadaType)
    }

}