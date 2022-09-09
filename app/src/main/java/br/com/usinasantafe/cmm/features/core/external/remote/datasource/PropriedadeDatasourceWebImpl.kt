package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.PropriedadeModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.PropriedadeDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class PropriedadeDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): PropriedadeDatasourceWeb {

    override suspend fun getAllPropriedade(): List<PropriedadeModel> {
        val propriedadeType = object : TypeToken<List<PropriedadeModel>>() {}.type
        val retorno = responseWeb.getGeneric("propriedade");
        return Gson().fromJson(retorno, propriedadeType)
    }

}