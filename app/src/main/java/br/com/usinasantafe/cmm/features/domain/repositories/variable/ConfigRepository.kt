package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config

interface ConfigRepository {

    suspend fun hasConfig(): Boolean

    suspend fun getConfig(): Config

    suspend fun saveConfig(nroEquip: String, senha: String)

    suspend fun sendUpdateApp(versao: String): Result<Config>

    suspend fun sentUpdateApp(config: Config)

    suspend fun setStatusSendConfig(statusSend: StatusSend)

}