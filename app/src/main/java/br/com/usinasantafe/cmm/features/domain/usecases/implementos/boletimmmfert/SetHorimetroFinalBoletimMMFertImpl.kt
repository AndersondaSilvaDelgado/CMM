package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroFinalBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendData
import javax.inject.Inject

class SetHorimetroFinalBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val startProcessSendData: StartProcessSendData
): SetHorimetroFinalBoletimMMFert {

    override suspend fun invoke(horimetroFinal: String): Boolean {
        return if(boletimMMFertRepository.setHorimetroFinalBoletimMMFert(horimetroFinal)){
            if(boletimMMFertRepository.finishBoletimMMFert()) {
                startProcessSendData()
                true
            } else {
                false
            }
        } else {
            false
        }
    }

}