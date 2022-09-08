package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.FrenteModel

interface FrenteDatasourceWeb {

    suspend fun getAllFrente(): List<FrenteModel>

}