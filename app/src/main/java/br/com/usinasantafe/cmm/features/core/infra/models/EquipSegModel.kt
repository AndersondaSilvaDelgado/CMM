package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.EquipSeg
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbequipsegest")
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
