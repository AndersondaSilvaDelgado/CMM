package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.PropriedadeModel

interface PropriedadeDatasourceWeb {

    suspend fun getAllPropriedade(): List<PropriedadeModel>

}