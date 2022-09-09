package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.remote.util.ResponseWeb
import br.com.usinasantafe.cmm.features.core.infra.models.TurnoModel
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.TurnoDatasourceWeb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class TurnoDatasourceWebImpl @Inject constructor(
    private val responseWeb: ResponseWeb
): TurnoDatasourceWeb {

    override suspend fun getAllTurno(): List<TurnoModel> {
        val turnoType = object : TypeToken<List<TurnoModel>>() {}.type
        val retorno = responseWeb.getGeneric("turno");
        return Gson().fromJson(retorno, turnoType)
    }

}