package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_ATIVIDADE
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_ATIVIDADE)
data class AtividadeRoomModel (
    @PrimaryKey val idAtiv: Long,
    val codAtiv: Long,
    val descrAtiv: String
)

fun AtividadeRoomModel.toAtividade(): Ativ {
    return with(this){
        Ativ(
            idAtiv = this.idAtiv,
            codAtiv = this.codAtiv,
            descrAtiv = this.descrAtiv
        )
    }
}

fun Ativ.toAtividadeModel(): AtividadeRoomModel{
    return with(this){
        AtividadeRoomModel(
            idAtiv = this.idAtiv,
            codAtiv = this.codAtiv,
            descrAtiv = this.descrAtiv
        )
    }
}