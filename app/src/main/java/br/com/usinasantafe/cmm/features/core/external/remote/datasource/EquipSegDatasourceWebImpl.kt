package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.EquipSegModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.EquipSegDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class EquipSegDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): EquipSegDatasourceWeb {

    override suspend fun getAllEquipSeg(): List<EquipSegModel> {
        val equipSegType = object : TypeToken<List<EquipSegModel>>() {}.type
        val retorno = responseWeb.getGeneric("equipseg");
        return Gson().fromJson(retorno, equipSegType)
    }

}