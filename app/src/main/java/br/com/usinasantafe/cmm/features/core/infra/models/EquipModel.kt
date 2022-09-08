package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.Equip
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbequipest")
data class EquipModel(
    @PrimaryKey val idEquip: Long,
    val nroEquip: Long,
    val codClasseEquip: Long?,
    val descrClasseEquip: String?,
    val codTurno: Long?,
    val idCheckList: Long?,
    val tipoEquipFert: Long?,
    val horimetroEquip: Double?,
    val medicaoEquipFert: Double?,
    val tipoEquip: Long?,
    val classifEquip: Long?
)

fun Equip.toEquipModel(): EquipModel{
    return with(this){
        EquipModel(
            idEquip = this.idEquip,
            nroEquip = this.nroEquip,
            codClasseEquip = this.codClasseEquip,
            descrClasseEquip = this.descrClasseEquip,
            codTurno = this.codTurno,
            idCheckList = this.idCheckList,
            tipoEquipFert = this.tipoEquipFert,
            horimetroEquip = this.horimetroEquip,
            medicaoEquipFert = this.medicaoEquipFert,
            tipoEquip = this.tipoEquip,
            classifEquip = this.classifEquip
        )
    }
}

fun EquipModel.toEquip(): Equip {
    return with(this){
        Equip(
            idEquip = this.idEquip,
            nroEquip = this.nroEquip,
            codClasseEquip = this.codClasseEquip,
            descrClasseEquip = this.descrClasseEquip,
            codTurno = this.codTurno,
            idCheckList = this.idCheckList,
            tipoEquipFert = this.tipoEquipFert,
            horimetroEquip = this.horimetroEquip,
            medicaoEquipFert = this.medicaoEquipFert,
            tipoEquip = this.tipoEquip,
            classifEquip = this.classifEquip,
            rEquipAtivList = emptyList(),
            rEquipPneuList = emptyList()
        )
    }
}
