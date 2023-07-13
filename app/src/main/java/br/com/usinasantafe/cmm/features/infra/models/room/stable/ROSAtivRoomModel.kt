package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_R_OS_ATIV
import br.com.usinasantafe.cmm.features.domain.entities.stable.ROSAtiv
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_R_OS_ATIV)
data class ROSAtivRoomModel(
    @PrimaryKey(autoGenerate = true)
    val idROSAtiv: Long,
    val idOS: Long,
    val idAtiv: Long
)

fun ROSAtiv.toROSAtivModel(): ROSAtivRoomModel{
    return with(this){
        ROSAtivRoomModel(
            idROSAtiv = this.idROSAtiv,
            idOS = this.idOS,
            idAtiv = this.idAtiv
        )
    }
}

fun ROSAtivRoomModel.toROSAtiv(): ROSAtiv {
    return with(this){
        ROSAtiv(
            idROSAtiv = this.idROSAtiv,
            idOS = this.idOS,
            idAtiv = this.idAtiv
        )
    }
}