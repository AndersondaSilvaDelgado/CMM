package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.OSModel

interface OSDatasourceWeb {

    suspend fun getAllOS(): List<OSModel>

}