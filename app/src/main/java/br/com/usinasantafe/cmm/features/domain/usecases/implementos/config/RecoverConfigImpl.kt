package br.com.usinasantafe.cmm.features.domain.usecases.implementos.config

import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.RecoverConfig
import javax.inject.Inject

class RecoverConfigImpl @Inject constructor (
    private val configRepository: ConfigRepository
): RecoverConfig {

    override suspend fun invoke(): Config? {
        return if (configRepository.hasSenhaConfig())
            configRepository.getConfig()
        else
            null
    }

}