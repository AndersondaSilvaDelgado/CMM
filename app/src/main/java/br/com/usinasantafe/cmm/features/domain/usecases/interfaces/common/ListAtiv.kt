package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.features.domain.entities.Atividade

interface ListAtiv {

    suspend operator fun invoke(): List<Atividade>

}