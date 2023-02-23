package br.com.usinasantafe.cmm.features.domain.usecases.implementos.common

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.CheckSendData
import javax.inject.Inject

class CheckSendDataImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository
) : CheckSendData {

    override suspend fun invoke(): Boolean {
        return apontMMFertRepository.checkApontSend() || boletimMMFertRepository.checkFechadoBoletimMMFertSend()
    }

}