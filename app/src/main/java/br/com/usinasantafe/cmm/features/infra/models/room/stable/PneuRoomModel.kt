package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PNEU
import br.com.usinasantafe.cmm.features.domain.entities.stable.Pneu
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PNEU)
data class PneuRoomModel(
    @PrimaryKey val idPneu: Long,
    val nroPneu: String
)

fun Pneu.toPneuModel(): PneuRoomModel{
    return with(this){
        PneuRoomModel(
            idPneu = this.idPneu,
            nroPneu = this.nroPneu
        )
    }
}

fun PneuRoomModel.toPneu(): Pneu {
    return with(this){
        Pneu(
            idPneu = this.idPneu,
            nroPneu = this.nroPneu
        )
    }
}