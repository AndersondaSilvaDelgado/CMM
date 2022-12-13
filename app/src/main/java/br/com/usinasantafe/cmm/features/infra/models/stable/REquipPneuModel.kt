package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_EQUIP_PNEU
import br.com.usinasantafe.cmm.features.domain.entities.stable.REquipPneu
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_EQUIP_PNEU)
data class REquipPneuModel(
    @PrimaryKey(autoGenerate = true)
    val idREquipPneu: Long,
    val idPosConfPneu: Long,
    val idPneu: Long,
    val posPneu: String
)

fun REquipPneu.toREquipPneuModel(): REquipPneuModel{
    return with(this){
        REquipPneuModel(
            idREquipPneu = this.idREquipPneu,
            idPosConfPneu = this.idPosConfPneu,
            idPneu = this.idPneu,
            posPneu = this.posPneu
        )
    }
}

fun REquipPneuModel.toREquipPneu(): REquipPneu {
    return with(this){
        REquipPneu(
            idREquipPneu = this.idREquipPneu,
            idPosConfPneu = this.idPosConfPneu,
            idPneu = this.idPneu,
            posPneu = this.posPneu
        )
    }
}
