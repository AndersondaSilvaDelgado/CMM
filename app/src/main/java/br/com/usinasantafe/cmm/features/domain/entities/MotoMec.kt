package br.com.usinasantafe.cmm.features.domain.entities

data class MotoMec(
    val idMotoMec: Long,
    val idOperMotoMec: Long,
    val descrOperMotoMec: String,
    val codFuncaoOperMotoMec: Long,
    val posOperMotoMec: Long,
    val tipoOperMotoMec: Long,
    val aplicOperMotoMec: Long,
    val funcaoOperMotoMec: Long
)
