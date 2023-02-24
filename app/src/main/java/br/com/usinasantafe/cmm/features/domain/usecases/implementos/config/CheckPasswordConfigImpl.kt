package br.com.usinasantafe.cmm.features.domain.usecases.implementos.config

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config.CheckPasswordConfig
import javax.inject.Inject

class CheckPasswordConfigImpl @Inject constructor(
    private val configRepository: ConfigRepository
): CheckPasswordConfig {

    override suspend fun invoke(senha: String): Boolean {
        return if (configRepository.hasConfig()) configRepository.getConfig().senhaConfig == senha else true
    }

}