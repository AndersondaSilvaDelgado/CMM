package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckOpenBoletimMMFert
import javax.inject.Inject

class CheckOpenBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): CheckOpenBoletimMMFert {

    override suspend fun invoke(): Boolean {
        return boletimMMFertRepository.checkAbertoBoletimMMFert()
    }

}