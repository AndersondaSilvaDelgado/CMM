package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList

data class RespItemCheckList(
    val idRespItemCheckList: Long? = null,
    val idItemRespItemCheckList: Long,
    val idCabecRespItemCheckList: Long,
    val opcaoRespItemCheckList: ChoiceCheckList,
)
