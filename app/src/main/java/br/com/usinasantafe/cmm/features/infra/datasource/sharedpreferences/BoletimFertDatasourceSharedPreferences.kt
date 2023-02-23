package br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert

interface BoletimFertDatasourceSharedPreferences: BoletimDatasourceSharedPreferences {

    suspend fun getBoletimFert(): BoletimFert

}