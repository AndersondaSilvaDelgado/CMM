package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.TypeNote
import java.util.*

data class ApontMM(
    var idApont: Long? = null,
    var idBolApont: Long,
    var tipoApont: TypeNote,
    var nroOSApont: Long? = null,
    var idAtivApont: Long? = null,
    var idParadaApont: Long? = null,
    var nroTransbApont: Long? = null,
    var dthrApont: Date = Date(),
    var statusConApont: StatusConnection? = null,
    var longitudeApont: Double? = null,
    var latitudeApont: Double? = null,
    var idFrenteApont: Long? = null,
    var idProprApont: Long? = null,
)