package br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM

interface BoletimMMDatasourceSharedPreferences: BoletimDatasourceSharedPreferences {

    suspend fun getBoletimMM(): BoletimMM

}