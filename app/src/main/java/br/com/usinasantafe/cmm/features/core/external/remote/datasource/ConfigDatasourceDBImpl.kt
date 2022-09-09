package br.com.usinasantafe.cmm.features.core.external.remote.datasource

import br.com.usinasantafe.cmm.features.core.external.database.dao.ConfigDao
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ConfigDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.models.ConfigModel
import javax.inject.Inject

class ConfigDatasourceDBImpl @Inject constructor (
    private val configDao: ConfigDao
): ConfigDatasourceDB {

    override suspend fun addConfig(configModel: ConfigModel): Long {
        return configDao.insert(configModel)
    }

    override suspend fun hasElementConfig(): Boolean {
        return configDao.size() > 0
    }

    override suspend fun deleteAllConfig() {
        configDao.deleteAll()
    }

    override suspend fun getConfig(): ConfigModel {
        return configDao.get()
    }

    override suspend fun getConfig(senha: String): ConfigModel {
        return configDao.get(senha)
    }


}