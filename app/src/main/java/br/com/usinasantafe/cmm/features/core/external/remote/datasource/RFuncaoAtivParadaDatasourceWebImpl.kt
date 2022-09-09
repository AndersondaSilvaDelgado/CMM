package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.RFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.RFuncaoAtivParadaDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class RFuncaoAtivParadaDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): RFuncaoAtivParadaDatasourceWeb {

    override suspend fun getAllRFuncaoAtivParada(): List<RFuncaoAtivParadaModel> {
        val rFuncaoAtivParadaType = object : TypeToken<List<RFuncaoAtivParadaModel>>() {}.type
        val retorno = responseWeb.getGeneric("rfuncaoativparada");
        return Gson().fromJson(retorno, rFuncaoAtivParadaType)
    }

}