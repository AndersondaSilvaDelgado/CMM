package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.StartBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendData
import javax.inject.Inject

class StartBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val startSendData: StartSendData
): StartBoletimMMFert {

    override suspend fun invoke() {
        boletimMMFertRepository.startBoletimMMFert()
        startSendData()
    }

}