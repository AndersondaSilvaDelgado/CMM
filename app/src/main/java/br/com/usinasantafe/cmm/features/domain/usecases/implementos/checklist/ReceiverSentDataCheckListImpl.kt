package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.ReceiverSentDataCheckList
import javax.inject.Inject

class ReceiverSentDataCheckListImpl @Inject constructor(
    private val cabecCheckListRepository: CabecCheckListRepository
) : ReceiverSentDataCheckList {

    override suspend fun invoke(cabecCheckListList: List<CabecCheckList>) {
        cabecCheckListRepository.receiverSentCabecCheckList(cabecCheckListList)
    }

}