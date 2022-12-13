package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import java.util.*

data class ApontMM(
    var idApont: Long? = null,
    var idBolApont: Long,
    var tipoApont: Long,
    var osApont: Long? = null,
    var ativApont: Long? = null,
    var paradaApont: Long? = null,
    var transbApont: Long? = null,
    var dthrApont: Date = Date(),
    var statusConApont: StatusConnection? = null,
    var longitudeApont: Double? = null,
    var latitudeApont: Double? = null,
    var idFrenteApont: Long? = null,
    var idProprApont: Long? = null,
)