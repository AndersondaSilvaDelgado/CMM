package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.OpenCheckList
import javax.inject.Inject

class OpenCheckListImpl @Inject constructor(
    private val cabecCheckListRepository: CabecCheckListRepository
): OpenCheckList {

    override suspend fun invoke(): Boolean {
        return cabecCheckListRepository.openCabecCheckList()
    }

}