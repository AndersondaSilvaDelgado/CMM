package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusConnection

data class ApontFert (
    var idApont: Long? = null,
    var idBolApont: Long,
    var tipoApont: Long,
    var osApont: Long? = null,
    var ativApont: Long? = null,
    var paradaApont: Long? = null,
    var pressaoApont: Double? = null,
    var velocApont: Long? = null,
    var bocalApont: Long? = null,
    var dthrApontLong: Long? = null,
    var dthrApont: String? = null,
    var statusConApont: StatusConnection? = null,
    var longitudeApont: Double? = null,
    var latitudeApont: Double? = null,
)