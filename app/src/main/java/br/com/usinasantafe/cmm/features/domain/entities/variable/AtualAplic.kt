package br.com.usinasantafe.cmm.features.domain.entities.variable

import java.util.*

data class AtualAplic(
    var idEquipAtual: Long? = null,
    var idCheckList: Long? = null,
    var versaoAtual: Double? = null,
    var versaoNova: Double? = null,
    var flagAtualApp: Boolean? = null,
    var flagAtualCheckList: Boolean? = null,
    var dthr: Date? = null,
)
