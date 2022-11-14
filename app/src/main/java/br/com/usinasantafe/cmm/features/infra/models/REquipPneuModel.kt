package br.com.usinasantafe.cmm.features.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.domain.entities.REquipPneu
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbrequippneuest")
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
