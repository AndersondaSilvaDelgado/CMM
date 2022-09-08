package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ConfigModel

interface ConfigDatasourceDB {

    suspend fun addConfig(configModel: ConfigModel): Long

    suspend fun hasElementConfig(): Boolean

    suspend fun deleteAllConfig()

    suspend fun getConfig(): ConfigModel

    suspend fun getConfig(senha: String): ConfigModel

}