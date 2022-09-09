package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.ParadaModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ParadaDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ParadaDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): ParadaDatasourceWeb {

    override suspend fun getAllParada(): List<ParadaModel> {
        val paradaType = object : TypeToken<List<ParadaModel>>() {}.type
        val retorno = responseWeb.getGeneric("parada");
        return Gson().fromJson(retorno, paradaType)
    }

}