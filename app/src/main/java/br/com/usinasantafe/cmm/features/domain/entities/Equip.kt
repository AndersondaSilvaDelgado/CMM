package br.com.usinasantafe.cmm.features.domain.entities

data class Equip(
    val idEquip: Long,
    val nroEquip: Long,
    val codClasseEquip: Long,
    val descrClasseEquip: String,
    val codTurno: Long,
    val idCheckList: Long,
    val tipoEquipFert: Long,
    val horimetroEquip: Double,
    val medicaoEquipFert: Double,
    val tipoEquip: Long,
    val classifEquip: Long,
)
