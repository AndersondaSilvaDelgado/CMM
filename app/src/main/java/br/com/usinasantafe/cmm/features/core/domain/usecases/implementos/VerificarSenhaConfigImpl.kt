package br.com.usinasantafe.cmm.features.core.domain.usecases.implementos

import br.com.usinasantafe.cmm.features.core.domain.repositories.ConfigRepository
import br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces.VerificarSenhaConfig
import javax.inject.Inject

class VerificarSenhaConfigImpl @Inject constructor(
    private val configRepository: ConfigRepository
): VerificarSenhaConfig {

    override suspend fun invoke(senha: String): Boolean {
        return if (configRepository.hasElementConfig())
            configRepository.getConfig(senha).equipConfig != null
        else
            true
    }

}