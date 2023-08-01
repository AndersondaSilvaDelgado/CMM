package br.com.usinasantafe.cmm.features.domain.usecases.implementos.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert.ReceiverSentDataBoletimMMFert
import javax.inject.Inject

class ReceiverSentDataBoletimMMFertImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
) : ReceiverSentDataBoletimMMFert {

    override suspend fun invoke(boletimMMList: List<BoletimMM>) {
        boletimMMFertRepository.receiverSentBoletimMMFert(boletimMMList)
    }

}