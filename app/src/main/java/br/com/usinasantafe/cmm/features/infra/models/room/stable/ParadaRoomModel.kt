package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PARADA
import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PARADA)
data class ParadaRoomModel(
    @PrimaryKey val idParada: Long,
    val codParada: Long,
    val descrParada: String
)

fun Parada.toParadaModel(): ParadaRoomModel{
    return with(this){
        ParadaRoomModel(
            idParada = this.idParada,
            codParada = this.codParada,
            descrParada = this.descrParada
        )
    }
}

fun ParadaRoomModel.toParada(): Parada {
    return with(this){
        Parada(
            idParada = this.idParada,
            codParada = this.codParada,
            descrParada = this.descrParada
        )
    }
}