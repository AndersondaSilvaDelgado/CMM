package br.com.usinasantafe.cmm.features.domain.usecases.implementos.config

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.HasConfig
import javax.inject.Inject

class HasConfigImpl @Inject constructor (
    private val configRepository: ConfigRepository
): HasConfig {

    override suspend fun invoke(): Boolean {
        return (configRepository.hasConfig())
    }

}