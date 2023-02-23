package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.common.utils.TypeNote
import java.util.*

data class ApontFert (
    var idApont: Long? = null,
    var idBolApont: Long? = null,
    var tipoApont: TypeNote? = null,
    var nroOSApont: Long? = null,
    var idAtivApont: Long? = null,
    var idParadaApont: Long? = null,
    var pressaoApont: Double? = null,
    var velocApont: Long? = null,
    var bocalApont: Long? = null,
    var dthrApont: Date = Date(),
    var statusConApont: StatusConnection? = null,
    var statusEnvioApont: StatusSend? = null,
    var longitudeApont: Double? = null,
    var latitudeApont: Double? = null,
)