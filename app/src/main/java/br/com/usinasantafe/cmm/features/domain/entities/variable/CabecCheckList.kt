package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import java.util.*

data class CabecCheckList (
    val idCabecCheckList: Long? = null,
    val nroEquipCabecCheckList: Long,
    val dtCabecCheckList: Date,
    val matricFuncCabecCheckList: Long,
    val idTurnoCabecCheckList: Long,
    val statusData: StatusData? = null,
    val statusSend: StatusSend? = null
)