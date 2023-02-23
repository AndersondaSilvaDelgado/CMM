package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import java.util.*

data class BoletimMM (
    var idBol: Long? = null,
    var matricFuncBol: Long? = null,
    var idEquipBol: Long? = null,
    var idTurnoBol: Long? = null,
    var hodometroInicialBol: Double? = null,
    var hodometroFinalBol: Double? = null,
    var nroOSBol: Long? = null,
    var idAtivBol: Long? = null,
    var dthrInicialBol: Date = Date(),
    var dthrFinalBol: Date = Date(),
    var statusBol: StatusData? = null,
    var statusConBol: StatusConnection? = null,
    var statusEnvioBol: StatusSend? = null,
    var longitudeBol: Double? = null,
    var latitudeBol: Double? = null,
    var apontList: List<ApontMM>? = emptyList(),
)