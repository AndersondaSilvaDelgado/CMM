package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.PneuModel

interface PneuDatasourceWeb {

    suspend fun getAllPneu(): List<PneuModel>

}