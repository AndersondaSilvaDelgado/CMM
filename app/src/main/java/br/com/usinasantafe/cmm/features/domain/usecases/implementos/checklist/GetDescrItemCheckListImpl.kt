package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.RespItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.GetDescrItemCheckList
import javax.inject.Inject

class GetDescrItemCheckListImpl @Inject constructor(
    private val itemCheckListRepository: ItemCheckListRepository
): GetDescrItemCheckList {

    override suspend fun invoke(position: Int): String {
        return itemCheckListRepository.getDescrItemCheckList(position)
    }

}