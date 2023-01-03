package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckAbertoBoletimMMFert
import javax.inject.Inject

class CheckAbertoBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): CheckAbertoBoletimMMFert {

    override suspend fun invoke(): Boolean {
        return boletimMMFertRepository.checkAbertoBoletimMMFert()
    }

}