package br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences

import br.com.usinasantafe.cmm.features.domain.entities.variable.Implemento

interface ImplementoDatasourceSharedPreferences {

    suspend fun addImplemento(implemento: Implemento): Boolean

    suspend fun clearData()

    suspend fun countImplemento(): Int

}