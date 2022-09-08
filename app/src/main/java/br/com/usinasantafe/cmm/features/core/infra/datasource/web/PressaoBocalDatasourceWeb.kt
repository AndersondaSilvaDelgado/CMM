package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.PressaoBocalModel

interface PressaoBocalDatasourceWeb {

    suspend fun getAllPressaoBocal(): List<PressaoBocalModel>

}