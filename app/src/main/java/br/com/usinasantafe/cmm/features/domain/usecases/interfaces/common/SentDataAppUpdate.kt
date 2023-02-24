package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.variable.AtualAplic

interface SentDataAppUpdate {

    suspend operator fun invoke(atualAplic: AtualAplic)

}