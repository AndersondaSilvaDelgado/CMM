package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.PneuModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.PneuDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class PneuDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): PneuDatasourceWeb {

    override suspend fun getAllPneu(): List<PneuModel> {
        val pneuType = object : TypeToken<List<PneuModel>>() {}.type
        val retorno = responseWeb.getGeneric("pneu");
        return Gson().fromJson(retorno, pneuType)
    }

}