package br.com.usinasantafe.cmm.features.domain.entities.variable

import br.com.usinasantafe.cmm.common.utils.StatusSend

data class Config(
    val equipConfig: Long,
    val senhaConfig: String,
    val statusEnvio: StatusSend
)