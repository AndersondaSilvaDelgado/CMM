package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_FUNCAO_ATIV_PARADA
import br.com.usinasantafe.cmm.features.domain.entities.stable.RFuncaoAtivParada
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_FUNCAO_ATIV_PARADA)
data class RFuncaoAtivParadaRoomModel(
    @PrimaryKey(autoGenerate = true)
    val idRFuncaoAtivPar: Long,
    val idAtivPar: Long,
    val codFuncao: Long,
    val tipoFuncao: Long
)

fun RFuncaoAtivParada.toRFuncaoAtivParadaModel(): RFuncaoAtivParadaRoomModel{
    return with(this){
        RFuncaoAtivParadaRoomModel(
            idRFuncaoAtivPar = this.idRFuncaoAtivPar,
            idAtivPar = this.idAtivPar,
            codFuncao = this.codFuncao,
            tipoFuncao = this.tipoFuncao
        )
    }
}

fun RFuncaoAtivParadaRoomModel.toRFuncaoAtivParada(): RFuncaoAtivParada {
    return with(this){
        RFuncaoAtivParada(
            idRFuncaoAtivPar = this.idRFuncaoAtivPar,
            idAtivPar = this.idAtivPar,
            codFuncao = this.codFuncao,
            tipoFuncao = this.tipoFuncao
        )
    }
}