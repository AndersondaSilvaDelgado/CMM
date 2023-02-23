package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend

data class BoletimFert (
    var idBol: Long? = null,
    var matricFuncBol: Long? = null,
    var idEquipBol: Long? = null,
    var idEquipBombaBol: Long? = null,
    var idTurnoBol: Long? = null,
    var hodometroInicialBol: Double? = null,
    var hodometroFinalBol: Double? = null,
    var nroOSBol: Long? = null,
    var idAtivBol: Long? = null,
    var dthrInicialBolLong: Long? = null,
    var dthrFinalBolLong: Long? = null,
    var dthrInicialBol: String? = null,
    var dthrFinalBol: String? = null,
    var statusBol: StatusData? = null,
    var statusConBol: StatusConnection? = null,
    var statusEnvioBol: StatusSend? = null,
    var longitudeBol: Double? = null,
    var latitudeBol: Double? = null,
    var apontList: List<ApontFert>? = emptyList(),
)