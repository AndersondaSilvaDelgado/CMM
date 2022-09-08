package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.LeiraModel

interface LeiraDatasourceWeb {

    suspend fun getAllLeira(): List<LeiraModel>

}