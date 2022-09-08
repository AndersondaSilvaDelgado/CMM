package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.AtividadeModel

interface AtividadeDatasourceWeb {

    suspend fun getAllAtividade(): List<AtividadeModel>

}