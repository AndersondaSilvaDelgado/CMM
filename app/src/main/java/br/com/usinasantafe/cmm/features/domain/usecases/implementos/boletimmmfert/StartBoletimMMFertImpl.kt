package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.StartBoletimMMFert
import javax.inject.Inject

class StartBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): StartBoletimMMFert {

    override suspend fun invoke() {
        boletimMMFertRepository.startBoletimMMFert()
    }

}