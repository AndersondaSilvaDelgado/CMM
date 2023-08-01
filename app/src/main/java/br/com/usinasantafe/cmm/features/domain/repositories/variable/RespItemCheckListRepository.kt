package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList

interface RespItemCheckListRepository {

    suspend fun countRespItemCheckListAberto(): Int

    suspend fun addRespItemCheckListAberto(choiceCheckList: ChoiceCheckList, position: Int): Boolean

    suspend fun deleteRespItemCheckListAberto(position: Int): Boolean

}