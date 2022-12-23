package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

import br.com.usinasantafe.cmm.common.utils.FlowNote
import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade

interface ListAtiv {

    suspend operator fun invoke(flowNote: FlowNote): List<Atividade>

}