package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.TurnoModel

interface TurnoDatasourceWeb {

    suspend fun getAllTurno(): List<TurnoModel>

}