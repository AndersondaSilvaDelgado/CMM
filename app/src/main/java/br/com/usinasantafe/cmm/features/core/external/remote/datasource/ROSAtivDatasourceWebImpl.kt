package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.ROSAtivModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ROSAtivDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ROSAtivDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): ROSAtivDatasourceWeb {

    override suspend fun getAllROSAtiv(): List<ROSAtivModel> {
        val rOSAtivType = object : TypeToken<List<ROSAtivModel>>() {}.type
        val retorno = responseWeb.getGeneric("rosativ");
        return Gson().fromJson(retorno, rOSAtivType)
    }

}