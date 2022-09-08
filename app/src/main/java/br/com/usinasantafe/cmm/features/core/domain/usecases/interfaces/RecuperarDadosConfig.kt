package br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces

import br.com.usinasantafe.cmm.features.core.domain.entities.Config

interface RecuperarDadosConfig {

    suspend operator fun invoke(): Config

}