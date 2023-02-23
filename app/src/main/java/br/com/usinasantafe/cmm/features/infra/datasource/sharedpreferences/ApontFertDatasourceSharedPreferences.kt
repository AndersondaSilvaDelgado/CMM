package br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert

interface ApontFertDatasourceSharedPreferences : ApontDatasourceSharedPreferences {

    suspend fun getApontFert(): ApontFert

}