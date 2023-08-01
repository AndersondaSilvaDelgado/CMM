package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.SendDataCheckList
import javax.inject.Inject

class SendDataCheckListImpl @Inject constructor(
    private val cabecCheckListRepository: CabecCheckListRepository
) : SendDataCheckList {

    override suspend fun invoke(): Result<List<CabecCheckList>> {
        return cabecCheckListRepository.sendCheckList()
    }

}