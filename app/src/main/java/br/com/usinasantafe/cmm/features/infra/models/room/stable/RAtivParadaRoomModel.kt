package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_ATIV_PARADA
import br.com.usinasantafe.cmm.features.domain.entities.stable.RAtivParada
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_ATIV_PARADA)
data class RAtivParadaRoomModel(
    @PrimaryKey(autoGenerate = true)
    val idRAtivParada: Long,
    val idAtiv: Long,
    val idParada: Long
)

fun RAtivParada.toRAtivParadaModel(): RAtivParadaRoomModel{
    return with(this){
        RAtivParadaRoomModel(
            idRAtivParada = this.idRAtivParada,
            idAtiv = this.idAtiv,
            idParada = this.idParada
        )
    }
}

fun RAtivParadaRoomModel.toRAtivParada(): RAtivParada {
    return with(this){
        RAtivParada(
            idRAtivParada = this.idRAtivParada,
            idAtiv = this.idAtiv,
            idParada = this.idParada
        )
    }
}
