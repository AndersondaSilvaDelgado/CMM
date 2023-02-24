package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.variable.AtualAplic

interface SendDataAppUpdate {

    suspend operator fun invoke(): Result<AtualAplic>

}