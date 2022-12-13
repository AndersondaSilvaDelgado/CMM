package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PNEU
import br.com.usinasantafe.cmm.features.domain.entities.stable.Pneu
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PNEU)
data class PneuModel(
    @PrimaryKey val idPneu: Long,
    val nroPneu: String
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