package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_FUNCAO_ATIV_PARADA
import br.com.usinasantafe.cmm.features.domain.entities.stable.RFuncaoAtivParada
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_FUNCAO_ATIV_PARADA)
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