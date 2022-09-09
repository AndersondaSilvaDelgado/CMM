package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.ComponenteModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ComponenteDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ComponenteDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): ComponenteDatasourceWeb {

    override suspend fun getAllComponente(): List<ComponenteModel> {
        val componenteType = object : TypeToken<List<ComponenteModel>>() {}.type
        val retorno = responseWeb.getGeneric("componente");
        return Gson().fromJson(retorno, componenteType)
    }

}