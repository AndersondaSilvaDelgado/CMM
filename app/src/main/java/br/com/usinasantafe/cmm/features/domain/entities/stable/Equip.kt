package br.com.usinasantafe.cmm.features.domain.entities.stable

data class Equip(
    val idEquip: Long,
    val nroEquip: Long,
    val codClasseEquip: Long,
    val descrClasseEquip: String,
    val codTurno: Long,
    val idCheckList: Long,
    val tipoEquip: Long,
    val horimetroEquip: Double,
    val medicaoEquipFert: Double,
    val classifEquip: Long,
)
