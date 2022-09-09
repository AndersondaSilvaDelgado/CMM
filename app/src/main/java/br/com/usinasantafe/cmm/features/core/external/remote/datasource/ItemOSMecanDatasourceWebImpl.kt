package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.ItemOSMecanModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ItemOSMecanDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ItemOSMecanDatasourceWebImpl @Inject constructor (
    private val responseWeb: ResponseWeb
): ItemOSMecanDatasourceWeb {

    override suspend fun getAllItemOSMecan(): List<ItemOSMecanModel> {
        val itemOSMecanType = object : TypeToken<List<ItemOSMecanModel>>() {}.type
        val retorno = responseWeb.getGeneric("itemosmecan");
        return Gson().fromJson(retorno, itemOSMecanType)
    }

}