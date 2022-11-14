package br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences

import br.com.usinasantafe.cmm.features.domain.entities.Config

interface ConfigDatasourceSharedPreferences {

    suspend fun hasSenhaConfig(): Boolean

    suspend fun senhaConfig(): String

    suspend fun getConfig(): Config

    suspend fun saveConfig(config: Config)

}