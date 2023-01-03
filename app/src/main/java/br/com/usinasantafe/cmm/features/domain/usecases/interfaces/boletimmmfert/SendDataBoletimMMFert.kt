package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM

interface SendDataBoletimMMFert {

    suspend operator fun invoke(): Result<List<BoletimMM>>

}