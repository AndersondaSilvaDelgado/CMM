package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.AtividadeModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.AtividadeDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class AtividadeDatasourceWebImpl @Inject constructor (
    private val responseWeb: ResponseWeb
): AtividadeDatasourceWeb {

    override suspend fun getAllAtividade(): List<AtividadeModel> {
        val atividadeType = object : TypeToken<List<AtividadeModel>>() {}.type
        val retorno = responseWeb.getGeneric("atividade");
        return Gson().fromJson(retorno, atividadeType)
    }

}