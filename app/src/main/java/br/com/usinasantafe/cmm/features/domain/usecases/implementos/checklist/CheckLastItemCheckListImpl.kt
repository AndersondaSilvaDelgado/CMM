package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist


import android.util.Log
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.RespItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.CheckLastItemCheckList
import javax.inject.Inject

class CheckLastItemCheckListImpl @Inject constructor(
    private val itemCheckListRepository: ItemCheckListRepository,
    private val respItemCheckListRepository: RespItemCheckListRepository
): CheckLastItemCheckList {

    override suspend fun invoke(): Boolean {
        return itemCheckListRepository.countItemCheckList() == respItemCheckListRepository.countRespItemCheckListAberto()
    }

}