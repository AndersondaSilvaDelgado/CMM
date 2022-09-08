package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.BocalModel

interface BocalDatasourceWeb {

    suspend fun getAllBocal(): List<BocalModel>

}