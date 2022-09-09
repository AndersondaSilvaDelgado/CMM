package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.ServicoModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ServicoDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ServicoDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): ServicoDatasourceWeb {

    override suspend fun getAllServico(): List<ServicoModel> {
        val servicoType = object : TypeToken<List<ServicoModel>>() {}.type
        val retorno = responseWeb.getGeneric("servico");
        return Gson().fromJson(retorno, servicoType)
    }

}