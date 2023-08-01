package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList
import br.com.usinasantafe.cmm.features.domain.repositories.variable.RespItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.AddRespItemCheckList
import javax.inject.Inject

class AddRespItemCheckListImpl @Inject constructor(
    private val respItemCheckListRepository: RespItemCheckListRepository
): AddRespItemCheckList {

    override suspend fun invoke(choiceCheckList: ChoiceCheckList, position: Int): Boolean {
        return respItemCheckListRepository.addRespItemCheckListAberto(choiceCheckList, position)
    }

}