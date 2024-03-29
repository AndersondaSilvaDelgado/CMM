package br.com.usinasantafe.cmm.features.domain.usecases.implementos.apontmmfert

import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ApontMMFertRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert.SetIdAtivApontMMFert
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendData

import javax.inject.Inject

class SetIdAtivApontMMFertImpl @Inject constructor(
    private val apontMMFertRepository: ApontMMFertRepository,
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val startProcessSendData: StartProcessSendData
): SetIdAtivApontMMFert {

    override suspend fun invoke(idAtiv: Long): TypeNote {
        if(!apontMMFertRepository.setIdAtivApontMMFert(idAtiv)){
            return TypeNote.FALHA
        }
        if (apontMMFertRepository.getTipoMMFert() == TypeNote.PARADA) {
            return TypeNote.PARADA
        }
        boletimMMFertRepository.setStatusEnviarBoletimMM(boletimMMFertRepository.getIdBoletimAberto())
        startProcessSendData()
        return TypeNote.TRABALHANDO
    }
}