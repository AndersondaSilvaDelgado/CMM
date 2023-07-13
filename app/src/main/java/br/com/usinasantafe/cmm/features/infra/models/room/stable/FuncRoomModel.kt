package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_FUNC
import br.com.usinasantafe.cmm.features.domain.entities.stable.Func
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_FUNC)
data class FuncRoomModel(
    @PrimaryKey val matricFunc: Long,
    val nomeFunc: String
)

fun Func.toFuncModel(): FuncRoomModel{
    return with(this){
        FuncRoomModel(
            matricFunc = this.matricFunc,
            nomeFunc = this.nomeFunc
        )
    }
}

fun FuncRoomModel.toFunc(): Func {
    return with(this){
        Func(
            matricFunc = this.matricFunc,
            nomeFunc = this.nomeFunc
        )
    }
}
