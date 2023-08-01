package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckStatusSend
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.SetStatusSendConfig
import javax.inject.Inject

class CheckStatusSendImpl @Inject constructor (
    private val configRepository: ConfigRepository,
    private val setStatusSendConfig: SetStatusSendConfig
): CheckStatusSend {

    override suspend fun invoke(): Boolean {
        return if(configRepository.getConfig().statusEnvio == StatusSend.SENT) {
            setStatusSendConfig(StatusSend.SEND)
            true
        } else false
    }

}