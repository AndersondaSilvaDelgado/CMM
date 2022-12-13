package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_OS_ATIV
import br.com.usinasantafe.cmm.features.domain.entities.stable.ROSAtiv
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_OS_ATIV)
data class ROSAtivModel(
    @PrimaryKey(autoGenerate = true)
    val idROSAtiv: Long,
    val idOS: Long,
    val idAtiv: Long
)

fun ROSAtiv.toROSAtivModel(): ROSAtivModel{
    return with(this){
        ROSAtivModel(
            idROSAtiv = this.idROSAtiv,
            idOS = this.idOS,
            idAtiv = this.idAtiv
        )
    }
}

fun ROSAtivModel.toROSAtiv(): ROSAtiv {
    return with(this){
        ROSAtiv(
            idROSAtiv = this.idROSAtiv,
            idOS = this.idOS,
            idAtiv = this.idAtiv
        )
    }
}