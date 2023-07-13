package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.SendDataAppUpdate
import javax.inject.Inject

class SendDataAppUpdateImpl @Inject constructor (
    private val configRepository: ConfigRepository
): SendDataAppUpdate {

    override suspend fun invoke(versao: String): Result<Config> {
        return configRepository.sendUpdateApp(versao)
    }

}