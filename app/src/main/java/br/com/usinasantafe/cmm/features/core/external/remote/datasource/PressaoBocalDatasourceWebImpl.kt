package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.PressaoBocalModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.PressaoBocalDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class PressaoBocalDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): PressaoBocalDatasourceWeb {

    override suspend fun getAllPressaoBocal(): List<PressaoBocalModel> {
        val pressaoBocalType = object : TypeToken<List<PressaoBocalModel>>() {}.type
        val retorno = responseWeb.getGeneric("pressaobocal");
        return Gson().fromJson(retorno, pressaoBocalType)
    }

}