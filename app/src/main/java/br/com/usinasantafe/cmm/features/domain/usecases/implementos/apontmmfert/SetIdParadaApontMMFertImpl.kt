package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetIdParadaApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartSendData
import javax.inject.Inject

class SetIdParadaApontMMFertImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val startSendData: StartSendData
): SetIdParadaApontMMFert {

    override suspend fun invoke(idParada: Long): Boolean {
        if(!apontMMFertRepository.setIdParadaApontMMFert(idParada)){
            return false
        }
        boletimMMFertRepository.setStatusEnviarBoletimMM(boletimMMFertRepository.getIdBoletim())
        startSendData()
        return true
    }

}