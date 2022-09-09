package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.EquipModel
import br.com.usinasantafe.cmm.features.core.infra.models.REquipAtivModel
import br.com.usinasantafe.cmm.features.core.infra.models.REquipPneuModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.EquipDatasourceWeb
import com.google.gson.Gson
import org.json.JSONObject
import javax.inject.Inject


class EquipDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): EquipDatasourceWeb {

    override suspend fun getDadosEquip(nroEquip: Long): List<Any> {

        var dados = responseWeb.postGeneric("pesqequip", nroEquip.toString())
        val list = mutableListOf<Any>()

        val equipJsonArray = JSONObject(dados).getJSONArray("Equip")
        for (i in 0 until equipJsonArray.length()) {
            val equipJSONObject = equipJsonArray.getJSONObject(i)
            list.add(Gson().fromJson(equipJSONObject.toString(), EquipModel::class.java))
        }

        val rEquipAtivJsonArray = JSONObject(dados).getJSONArray("REquipAtiv")
        for (i in 0 until rEquipAtivJsonArray.length()) {
            val rEquipAtivJSONObject = rEquipAtivJsonArray.getJSONObject(i)
            list.add(Gson().fromJson(rEquipAtivJSONObject.toString(), REquipAtivModel::class.java))
        }

        val rEquipPneuJsonArray = JSONObject(dados).getJSONArray("REquipPneu")
        for (i in 0 until rEquipPneuJsonArray.length()) {
            val rEquipPneuJSONObject = rEquipPneuJsonArray.getJSONObject(i)
            list.add(Gson().fromJson(rEquipPneuJSONObject.toString(), REquipPneuModel::class.java))
        }

        return list
    }

}