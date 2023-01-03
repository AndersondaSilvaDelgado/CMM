package br.com.usinasantafe.cmm.features.domain.usecases.implementos.config

import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SetStatusSendConfig
import javax.inject.Inject

class SetStatusSendConfigImpl @Inject constructor(
    private val configRepository: ConfigRepository
): SetStatusSendConfig {

    override suspend fun invoke(statusSend: StatusSend) {
        configRepository.setStatusSendConfig(statusSend)
    }

}