package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckSendBoletimMM
import javax.inject.Inject

class CheckSendBoletimMMImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository
) : CheckSendBoletimMM {

    override suspend fun invoke(): Boolean {
        return boletimMMFertRepository.checkBoletimSend()
    }

}