package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.SentDataBoletimMMFert
import javax.inject.Inject

class SentDataBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
) : SentDataBoletimMMFert {

    override suspend fun invoke(boletimMMList: List<BoletimMM>) {
        boletimMMFertRepository.sentBoletimMMFert(boletimMMList)
    }

}