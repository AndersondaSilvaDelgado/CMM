package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import java.util.*

data class CabecCheckList (
    val idCabecCheckList: Long? = null,
    val nroEquipCabecCheckList: Long? = null,
    val dtCabecCheckList: Date? = null,
    val matricFuncCabecCheckList: Long? = null,
    val idTurnoCabecCheckList: Long? = null,
    val statusData: StatusData? = null,
    val statusSend: StatusSend? = null,
    var respItemList: List<RespItemCheckList>? = emptyList(),
)