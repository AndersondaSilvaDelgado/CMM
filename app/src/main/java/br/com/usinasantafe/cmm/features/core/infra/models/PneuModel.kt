package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.Pneu
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbpneuest")
data class PneuModel(
    @PrimaryKey val idPneu: Long,
    val nroPneu: Long
)

fun Pneu.toPneuModel(): PneuModel{
    return with(this){
        PneuModel(
            idPneu = this.idPneu,
            nroPneu = this.nroPneu
        )
    }
}

fun PneuModel.toPneu(): Pneu {
    return with(this){
        Pneu(
            idPneu = this.idPneu,
            nroPneu = this.nroPneu
        )
    }
}