package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CloseCheckList
import br.com.usinasantafe.cmm.features.domain.usecases.workmanager.StartProcessSendData

import javax.inject.Inject

class CloseCheckListImpl @Inject constructor(
    private val cabecCheckListRepository: CabecCheckListRepository,
    private val startProcessSendData: StartProcessSendData
): CloseCheckList {

    override suspend fun invoke(): Boolean {
        return if(cabecCheckListRepository.closeCabecCheckList()) {
            startProcessSendData()
            true
        } else {
            false
        }
    }

}