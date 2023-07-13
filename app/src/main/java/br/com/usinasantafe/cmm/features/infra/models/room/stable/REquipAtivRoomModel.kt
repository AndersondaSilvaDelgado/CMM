package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_ATIV
import br.com.usinasantafe.cmm.features.domain.entities.stable.REquipAtiv
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_EQUIP_ATIV)
data class REquipAtivRoomModel(
    @PrimaryKey(autoGenerate = true)
    val idEquipAtiv: Long,
    val idEquip: Long,
    val idAtiv: Long
)

fun REquipAtiv.toREquipAtivModel(): REquipAtivRoomModel{
    return with(this){
        REquipAtivRoomModel(
            idEquipAtiv = this.idEquipAtiv,
            idEquip = this.idEquip,
            idAtiv = this.idAtiv
        )
    }
}

fun REquipAtivRoomModel.toREquipAtiv(): REquipAtiv {
    return with(this){
        REquipAtiv(
            idEquipAtiv = this.idEquipAtiv,
            idEquip = this.idEquip,
            idAtiv = this.idAtiv
        )
    }
}
