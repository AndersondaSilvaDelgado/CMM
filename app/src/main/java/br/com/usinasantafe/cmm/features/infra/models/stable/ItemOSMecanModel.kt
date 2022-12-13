package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_ITEM_OS_MECAN
import br.com.usinasantafe.cmm.features.domain.entities.stable.ItemOSMecan
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_ITEM_OS_MECAN)
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