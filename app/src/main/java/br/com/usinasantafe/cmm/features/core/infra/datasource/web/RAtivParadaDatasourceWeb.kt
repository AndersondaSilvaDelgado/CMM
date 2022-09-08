package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.RAtivParadaModel

interface RAtivParadaDatasourceWeb {

    suspend fun getAllRAtivParada(): List<RAtivParadaModel>

}