package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.RFuncaoAtivParada
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbrfuncaoativparadaest")
data class RFuncaoAtivParadaModel(
    @PrimaryKey(autoGenerate = true)
    val idRFuncaoAtivPar: Long,
    val idAtivPar: Long,
    val codFuncao: Long,
    val tipoFuncao: Long
)

fun RFuncaoAtivParada.toRFuncaoAtivParadaModel(): RFuncaoAtivParadaModel{
    return with(this){
        RFuncaoAtivParadaModel(
            idRFuncaoAtivPar = this.idRFuncaoAtivPar,
            idAtivPar = this.idAtivPar,
            codFuncao = this.codFuncao,
            tipoFuncao = this.tipoFuncao
        )
    }
}

fun RFuncaoAtivParadaModel.toRFuncaoAtivParada(): RFuncaoAtivParada {
    return with(this){
        RFuncaoAtivParada(
            idRFuncaoAtivPar = this.idRFuncaoAtivPar,
            idAtivPar = this.idAtivPar,
            codFuncao = this.codFuncao,
            tipoFuncao = this.tipoFuncao
        )
    }
}