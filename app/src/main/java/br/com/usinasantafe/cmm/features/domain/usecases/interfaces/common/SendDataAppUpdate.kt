package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.variable.Config

interface SendDataAppUpdate {

    suspend operator fun invoke(versao: String): Result<Config>

}