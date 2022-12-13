package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.config

import br.com.usinasantafe.cmm.features.domain.entities.variable.Config

interface RecoverConfig {

    suspend operator fun invoke(): Config?

}