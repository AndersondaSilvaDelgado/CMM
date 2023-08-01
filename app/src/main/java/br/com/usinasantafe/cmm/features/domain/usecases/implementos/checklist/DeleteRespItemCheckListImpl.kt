package br.com.usinasantafe.cmm.features.domain.usecases.implementos.checklist

import br.com.usinasantafe.cmm.features.domain.repositories.variable.RespItemCheckListRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist.DeleteRespItemCheckList
import javax.inject.Inject

class DeleteRespItemCheckListImpl @Inject constructor(
    private val respItemCheckListRepository: RespItemCheckListRepository
): DeleteRespItemCheckList {

    override suspend fun invoke(position: Int): Boolean {
        return respItemCheckListRepository.deleteRespItemCheckListAberto(position)
    }

}