package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.ComponenteModel

interface ComponenteDatasourceWeb {

    suspend fun getAllComponente(): List<ComponenteModel>

}