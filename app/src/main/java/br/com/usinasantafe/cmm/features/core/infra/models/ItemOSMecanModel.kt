package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.ItemOSMecan
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbitemosmecanest")
data class ItemOSMecanModel(
    @PrimaryKey val idItemOS: Long,
    val idOS: Long,
    val seqItemOS: Long,
    val idServItemOS: Long,
    val idCompItemOS: Long,
)

fun ItemOSMecan.toItemOSMecanModel(): ItemOSMecanModel{
    return with(this){
        ItemOSMecanModel(
            idItemOS = this.idItemOS,
            idOS = this.idOS,
            seqItemOS = this.seqItemOS,
            idServItemOS = this.idServItemOS,
            idCompItemOS = this.idCompItemOS
        )
    }
}

fun ItemOSMecanModel.toItemOSMecan(): ItemOSMecan {
    return with(this){
        ItemOSMecan(
            idItemOS = this.idItemOS,
            idOS = this.idOS,
            seqItemOS = this.seqItemOS,
            idServItemOS = this.idServItemOS,
            idCompItemOS = this.idCompItemOS
        )
    }
}