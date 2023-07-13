package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.SentDataAppUpdate
import javax.inject.Inject

class SentDataAppUpdateImpl @Inject constructor (
    private val configRepository: ConfigRepository
): SentDataAppUpdate {

    override suspend fun invoke(config: Config) {
        configRepository.sentUpdateApp(config)
    }

}