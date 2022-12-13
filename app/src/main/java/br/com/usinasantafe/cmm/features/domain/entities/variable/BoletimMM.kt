package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import java.util.*

data class BoletimMM (
    var idBol: Long? = null,
    var matricFuncBol: Long? = null,
    var idEquipBol: Long,
    var idTurnoBol: Long? = null,
    var hodometroInicialBol: Double? = null,
    var hodometroFinalBol: Double? = null,
    var osBol: Long? = null,
    var ativPrincBol: Long? = null,
    var dthrInicialBol: Date = Date(),
    var dthrFinalBol: Date = Date(),
    var statusBol: StatusData,
    var statusConBol: StatusConnection? = null,
    var longitudeBol: Double? = null,
    var latitudeBol: Double? = null,
    var apontList: List<ApontMM>? = emptyList(),
)