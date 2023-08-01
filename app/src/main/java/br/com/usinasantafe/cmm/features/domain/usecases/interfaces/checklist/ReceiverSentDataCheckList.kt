package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList

interface ReceiverSentDataCheckList {

    suspend operator fun invoke(cabecCheckListList: List<CabecCheckList>)

}