package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.CheckDataSendBoletimMMFert
import javax.inject.Inject

class CheckDataSendBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
): CheckDataSendBoletimMMFert {
    override suspend fun invoke(): Boolean {
        TODO("Not yet implemented")
    }
}