package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.ItemCheckListModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ItemCheckListDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ItemCheckListDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): ItemCheckListDatasourceWeb {

    override suspend fun getAllItemCheckList(): List<ItemCheckListModel> {
        val itemCheckListType = object : TypeToken<List<ItemCheckListModel>>() {}.type
        val retorno = responseWeb.getGeneric("itemchecklist");
        return Gson().fromJson(retorno, itemCheckListType)
    }

}