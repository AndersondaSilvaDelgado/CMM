package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SendDataBoletimMMFert
import javax.inject.Inject

class SendDataBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
) : SendDataBoletimMMFert {

    override suspend fun invoke(): Result<List<BoletimMM>> {
        return boletimMMFertRepository.sendBoletimMMAbertoFert()
    }

}