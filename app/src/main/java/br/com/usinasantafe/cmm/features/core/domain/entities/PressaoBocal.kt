package br.com.usinasantafe.cmm.features.core.domain.entities

data class PressaoBocal(
    val idPressaoBocal: Long,
    val idBocal: Long,
    val valorPressao: Double,
    val valorVeloc: Long
)
