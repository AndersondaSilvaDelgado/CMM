package br.com.usinasantafe.cmm.features.infra.repositories.variable

import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.infra.datasource.sharedpreferences.ConfigDatasourceSharedPreferences
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.variable.ConfigDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.toConfig
import br.com.usinasantafe.cmm.features.infra.models.variable.webservice.toConfigWebServiceModel
import javax.inject.Inject

class ConfigRepositoryImpl @Inject constructor (
    private val equipRepository: EquipRepository,
    private val configDatasourceSharedPreferences: ConfigDatasourceSharedPreferences,
    private val configDatasourceWebService: ConfigDatasourceWebService
): ConfigRepository {

    override suspend fun hasConfig(): Boolean {
        return configDatasourceSharedPreferences.hasConfig()
    }

    override suspend fun getConfig(): Config {
        return configDatasourceSharedPreferences.getConfig()
    }

    override suspend fun saveConfig(nroEquip: String, senha: String) {
        configDatasourceSharedPreferences.saveConfig(Config(nroEquip.toLong(), senha, StatusSend.SENT))
    }

    override suspend fun sendUpdateApp(versao: String): Result<Config> {
        var config = configDatasourceSharedPreferences.getConfig()
        config.versionCurrent = versao.toDouble()
        config.idCheckList = equipRepository.getEquip().idCheckList
        return configDatasourceWebService.sendConfig(config.toConfigWebServiceModel()).map { it.toConfig() }
    }

    override suspend fun sentUpdateApp(config: Config) {
        var configBD = configDatasourceSharedPreferences.getConfig()
        configBD.flagUpdateApp = config.flagUpdateApp
        configBD.flagUpdateCheckList = config.flagUpdateCheckList
        configBD.dthrServer = config.dthrServer
        configDatasourceSharedPreferences.saveConfig(configBD)
    }

    override suspend fun setStatusSendConfig(statusSend: StatusSend) {
        configDatasourceSharedPreferences.setStatusSend(statusSend)
    }

}