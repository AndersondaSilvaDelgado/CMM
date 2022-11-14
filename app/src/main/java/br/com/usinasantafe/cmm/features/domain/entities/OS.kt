package br.com.usinasantafe.cmm.features.domain.entities

data class OS(
    val idOS: Long,
    val nroOS: Long,
    val idLibOS: Long?,
    val idProprAgr: Long?,
    val areaProgrOS: Double?,
    val tipoOS: Long?
    ,
    val idEquip: Long?
)
