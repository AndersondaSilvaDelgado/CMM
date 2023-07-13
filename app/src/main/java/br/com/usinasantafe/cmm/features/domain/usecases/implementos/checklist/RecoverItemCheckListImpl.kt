package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.CabecCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.RespItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.RecoverItemCheckList
import javax.inject.Inject

class RecoverItemCheckListImpl @Inject constructor(
    private val cabecCheckListRepository: CabecCheckListRepository,
    private val itemCheckListRepository: ItemCheckListRepository,
    private val respItemCheckListRepository: RespItemCheckListRepository
): RecoverItemCheckList {

    override suspend fun invoke(): String {
        TODO("Not yet implemented")
    }

}