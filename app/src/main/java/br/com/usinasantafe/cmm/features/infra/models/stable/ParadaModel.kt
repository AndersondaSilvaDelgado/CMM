package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PARADA
import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PARADA)
data class ParadaModel(
    @PrimaryKey val idParada: Long,
    val codParada: Long,
    val descrParada: String
)

fun Parada.toParadaModel(): ParadaModel{
    return with(this){
        ParadaModel(
            idParada = this.idParada,
            codParada = this.codParada,
            descrParada = this.descrParada
        )
    }
}

fun ParadaModel.toParada(): Parada {
    return with(this){
        Parada(
            idParada = this.idParada,
            codParada = this.codParada,
            descrParada = this.descrParada
        )
    }
}