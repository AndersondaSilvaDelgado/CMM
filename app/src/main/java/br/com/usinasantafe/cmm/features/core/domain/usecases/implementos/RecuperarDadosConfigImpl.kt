package br.com.usinasantafe.cmm.features.core.domain.usecases.implementos

import br.com.usinasantafe.cmm.features.core.domain.entities.Config
import br.com.usinasantafe.cmm.features.core.domain.repositories.ConfigRepository
import br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces.RecuperarDadosConfig
import javax.inject.Inject

class RecuperarDadosConfigImpl  @Inject constructor(
    private val configRepository: ConfigRepository
): RecuperarDadosConfig {

    override suspend fun invoke(): Config {
        return if (configRepository.hasElementConfig())
            configRepository.getConfig()
        else
            Config(0L, "")
    }

}