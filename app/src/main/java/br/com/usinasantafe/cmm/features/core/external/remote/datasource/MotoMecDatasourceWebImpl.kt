package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.MotoMecModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.MotoMecDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MotoMecDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): MotoMecDatasourceWeb {

    override suspend fun getAllMotoMec(): List<MotoMecModel> {
        val motoMecType = object : TypeToken<List<MotoMecModel>>() {}.type
        val retorno = responseWeb.getGeneric("motomec");
        return Gson().fromJson(retorno, motoMecType)
    }

}