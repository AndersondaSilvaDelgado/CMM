package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_OPER_MOTOMEC
import br.com.usinasantafe.cmm.features.domain.entities.stable.OperMotoMec
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_OPER_MOTOMEC)
data class OperMotoMecRoomModel(
    @PrimaryKey val idOperMotoMec: Long,
    val idAtivParOperMotoMec: Long,
    val descrAtivParOperMotoMec: String,
    val codFuncaoOperMotoMec: Long,
    val posOperMotoMec: Long,
    val tipoOperMotoMec: Long,
    val aplicOperMotoMec: Long,
    val funcaoOperMotoMec: Long
)

fun OperMotoMec.toMotoMecModel(): OperMotoMecRoomModel{
    return with(this){
        OperMotoMecRoomModel(
            idOperMotoMec = this.idOperMotoMec,
            idAtivParOperMotoMec = this.idAtivParOperMotoMec,
            descrAtivParOperMotoMec = this.descrAtivParOperMotoMec,
            codFuncaoOperMotoMec = this.codFuncaoOperMotoMec,
            posOperMotoMec = this.posOperMotoMec,
            tipoOperMotoMec = this.tipoOperMotoMec,
            aplicOperMotoMec = this.aplicOperMotoMec,
            funcaoOperMotoMec = this.funcaoOperMotoMec
        )
    }
}

fun OperMotoMecRoomModel.toMotoMec(): OperMotoMec {
    return with(this){
        OperMotoMec(
            idOperMotoMec = this.idOperMotoMec,
            idAtivParOperMotoMec = this.idAtivParOperMotoMec,
            descrAtivParOperMotoMec = this.descrAtivParOperMotoMec,
            codFuncaoOperMotoMec = this.codFuncaoOperMotoMec,
            posOperMotoMec = this.posOperMotoMec,
            tipoOperMotoMec = this.tipoOperMotoMec,
            aplicOperMotoMec = this.aplicOperMotoMec,
            funcaoOperMotoMec = this.funcaoOperMotoMec
        )
    }
}
