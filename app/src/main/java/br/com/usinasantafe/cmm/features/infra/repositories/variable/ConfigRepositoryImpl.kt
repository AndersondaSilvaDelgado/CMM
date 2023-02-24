package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ConfigDatasourceSharedPreferences
import javax.inject.Inject

class ConfigRepositoryImpl @Inject constructor (
    private val configDatasourceSharedPreferences: ConfigDatasourceSharedPreferences
): ConfigRepository {

    override suspend fun hasConfig(): Boolean {
        return configDatasourceSharedPreferences.hasConfig()
    }

    override suspend fun getConfig(): Config {
        return configDatasourceSharedPreferences.getConfig()
    }

    override suspend fun saveConfig(nroEquip: String, senha: String) {
        configDatasourceSharedPreferences.saveConfig(Config(nroEquip.toLong(), senha, StatusSend.ENVIADO))
    }

    override suspend fun setStatusSendConfig(statusSend: StatusSend) {
        configDatasourceSharedPreferences.setStatusSend(statusSend)
    }

}