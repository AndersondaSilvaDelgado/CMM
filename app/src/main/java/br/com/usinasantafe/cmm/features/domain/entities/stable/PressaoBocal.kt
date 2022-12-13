package br.com.usinasantafe.cmm.features.domain.entities.stable

data class PressaoBocal(
    val idPressaoBocal: Long,
    val idBocal: Long,
    val valorPressao: Double,
    val valorVeloc: Long
)
