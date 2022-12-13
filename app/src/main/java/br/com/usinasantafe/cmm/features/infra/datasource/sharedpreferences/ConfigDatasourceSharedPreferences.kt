package br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences

import br.com.usinasantafe.cmm.features.domain.entities.variable.Config

interface ConfigDatasourceSharedPreferences {

    suspend fun hasSenhaConfig(): Boolean

    suspend fun senhaConfig(): String

    suspend fun getConfig(): Config

    suspend fun saveConfig(config: Config)

}