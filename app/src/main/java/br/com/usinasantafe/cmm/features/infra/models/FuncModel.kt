package br.com.usinasantafe.cmm.features.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.domain.entities.Func
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbfuncest")
data class FuncModel(
    @PrimaryKey val matricFunc: Long,
    val nomeFunc: String
)

fun Func.toFuncModel(): FuncModel{
    return with(this){
        FuncModel(
            matricFunc = this.matricFunc,
            nomeFunc = this.nomeFunc
        )
    }
}

fun FuncModel.toFunc(): Func {
    return with(this){
        Func(
            matricFunc = this.matricFunc,
            nomeFunc = this.nomeFunc
        )
    }
}
