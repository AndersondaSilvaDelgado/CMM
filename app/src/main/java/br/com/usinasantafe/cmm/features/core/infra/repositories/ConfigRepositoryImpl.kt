package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Config
import br.com.usinasantafe.cmm.features.core.domain.repositories.ConfigRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ConfigDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.models.toConfig
import br.com.usinasantafe.cmm.features.core.infra.models.toConfigModel
import javax.inject.Inject

class ConfigRepositoryImpl @Inject constructor (
    private val configDatasourceDB: ConfigDatasourceDB
): ConfigRepository {

    override suspend fun addConfig(config: Config) {
       configDatasourceDB.addConfig(config.toConfigModel())
    }

    override suspend fun hasElementConfig(): Boolean {
        return configDatasourceDB.hasElementConfig()
    }

    override suspend fun deleteAllConfig() {
        configDatasourceDB.deleteAllConfig()
    }

    override suspend fun getConfig(): Config {
        return configDatasourceDB.getConfig().toConfig()
    }

    override suspend fun getConfig(senha: String): Config {
        return configDatasourceDB.getConfig(senha).toConfig()
    }

}