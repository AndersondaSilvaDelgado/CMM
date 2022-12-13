package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_ATIV
import br.com.usinasantafe.cmm.features.domain.entities.stable.REquipAtiv
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_EQUIP_ATIV)
data class REquipAtivModel(
    @PrimaryKey(autoGenerate = true)
    val idEquipAtiv: Long,
    val idEquip: Long,
    val idAtiv: Long
)

fun REquipAtiv.toREquipAtivModel(): REquipAtivModel{
    return with(this){
        REquipAtivModel(
            idEquipAtiv = this.idEquipAtiv,
            idEquip = this.idEquip,
            idAtiv = this.idAtiv
        )
    }
}

fun REquipAtivModel.toREquipAtiv(): REquipAtiv {
    return with(this){
        REquipAtiv(
            idEquipAtiv = this.idEquipAtiv,
            idEquip = this.idEquip,
            idAtiv = this.idAtiv
        )
    }
}
