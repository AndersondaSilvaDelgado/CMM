package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_EQUIP
import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_EQUIP)
data class EquipRoomModel(
    @PrimaryKey val idEquip: Long,
    val nroEquip: Long,
    val codClasseEquip: Long,
    val descrClasseEquip: String,
    val codTurno: Long,
    val idCheckList: Long,
    val horimetroEquip: Double,
    val medicaoEquipFert: Double,
    val tipoEquip: Long,
    val classifEquip: Long
)

fun Equip.toEquipModel(): EquipRoomModel{
    return with(this){
        EquipRoomModel(
            idEquip = this.idEquip,
            nroEquip = this.nroEquip,
            codClasseEquip = this.codClasseEquip,
            descrClasseEquip = this.descrClasseEquip,
            codTurno = this.codTurno,
            idCheckList = this.idCheckList,
            horimetroEquip = this.horimetroEquip,
            medicaoEquipFert = this.medicaoEquipFert,
            tipoEquip = this.tipoEquip,
            classifEquip = this.classifEquip
        )
    }
}

fun EquipRoomModel.toEquip(): Equip {
    return with(this){
        Equip(
            idEquip = this.idEquip,
            nroEquip = this.nroEquip,
            codClasseEquip = this.codClasseEquip,
            descrClasseEquip = this.descrClasseEquip,
            codTurno = this.codTurno,
            idCheckList = this.idCheckList,
            horimetroEquip = this.horimetroEquip,
            medicaoEquipFert = this.medicaoEquipFert,
            tipoEquip = this.tipoEquip,
            classifEquip = this.classifEquip,
        )
    }
}
