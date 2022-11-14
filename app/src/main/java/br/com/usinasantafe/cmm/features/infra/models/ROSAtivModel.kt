package br.com.usinasantafe.cmm.features.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.domain.entities.ROSAtiv
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbrosativest")
data class ROSAtivModel(
    @PrimaryKey(autoGenerate = true)
    val idROSAtiv: Long,
    val nroOS: Long,
    val idAtiv: Long
)

fun ROSAtiv.toROSAtivModel(): ROSAtivModel{
    return with(this){
        ROSAtivModel(
            idROSAtiv = this.idROSAtiv,
            nroOS = this.idOS,
            idAtiv = this.idAtiv
        )
    }
}

fun ROSAtivModel.toROSAtiv(): ROSAtiv {
    return with(this){
        ROSAtiv(
            idROSAtiv = this.idROSAtiv,
            idOS = this.nroOS,
            idAtiv = this.idAtiv
        )
    }
}