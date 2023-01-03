package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config

import br.com.usinasantafe.cmm.common.utils.StatusSend

interface SetStatusSendConfig {

    suspend operator fun invoke(statusSend: StatusSend)

}