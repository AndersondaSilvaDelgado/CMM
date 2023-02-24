package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SetHorimetroInicialBoletimMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendData
import javax.inject.Inject

class SetHorimetroInicialBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val startSendData: StartSendData
): SetHorimetroInicialBoletimMMFert {

    override suspend fun invoke(horimetroInicial: String): Boolean {
        return if(boletimMMFertRepository.setHorimetroInicialBoletimMMFert(horimetroInicial)) {
            if(boletimMMFertRepository.insertBoletimMMFert()){
                startSendData()
                true
            } else false
        } else false
    }

}