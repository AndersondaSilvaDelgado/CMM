package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_EQUIP_SEG
import br.com.usinasantafe.cmm.features.domain.entities.stable.EquipSeg
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_EQUIP_SEG)
data class EquipSegModel(
    @PrimaryKey val idEquip: Long,
    val nroEquip: Long,
    val codClasseEquip: Long,
    val descrClasseEquip: String,
    val tipoEquip: Long //1 - Carretel; 2 - Transbordo; 3 - Implemento
)

fun EquipSeg.toEquipSegModel(): EquipSegModel{
    return with(this){
        EquipSegModel(
            idEquip = this.idEquip,
            nroEquip = this.nroEquip,
            codClasseEquip = this.codClasseEquip,
            descrClasseEquip = this.descrClasseEquip,
            tipoEquip = this.tipoEquip
        )
    }
}

fun EquipSegModel.toEquipSeg(): EquipSeg {
    return with(this){
        EquipSeg(
            idEquip = this.idEquip,
            nroEquip = this.nroEquip,
            codClasseEquip = this.codClasseEquip,
            descrClasseEquip = this.descrClasseEquip,
            tipoEquip = this.tipoEquip
        )
    }
}
