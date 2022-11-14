package br.com.usinasantafe.cmm.features.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.domain.entities.RAtivParada
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbrativparadaest")
data class RAtivParadaModel(
    @PrimaryKey(autoGenerate = true)
    val idRAtivParada: Long,
    val idAtiv: Long,
    val idParada: Long
)

fun RAtivParada.toRAtivParadaModel(): RAtivParadaModel{
    return with(this){
        RAtivParadaModel(
            idRAtivParada = this.idRAtivParada,
            idAtiv = this.idAtiv,
            idParada = this.idParada
        )
    }
}

fun RAtivParadaModel.toRAtivParada(): RAtivParada {
    return with(this){
        RAtivParada(
            idRAtivParada = this.idRAtivParada,
            idAtiv = this.idAtiv,
            idParada = this.idParada
        )
    }
}
