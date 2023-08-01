package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList

interface AddRespItemCheckList {

    suspend operator fun invoke(choiceCheckList: ChoiceCheckList, position: Int): Boolean

}