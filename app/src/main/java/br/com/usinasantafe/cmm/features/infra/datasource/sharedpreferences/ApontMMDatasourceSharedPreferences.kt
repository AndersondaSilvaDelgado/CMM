package br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM

interface ApontMMDatasourceSharedPreferences : ApontDatasourceSharedPreferences {

    suspend fun getApontMM(): ApontMM

}