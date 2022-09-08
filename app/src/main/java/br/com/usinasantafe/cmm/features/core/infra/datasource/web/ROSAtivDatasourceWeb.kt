package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.ROSAtivModel

interface ROSAtivDatasourceWeb {

    suspend fun getAllROSAtiv(): List<ROSAtivModel>

}