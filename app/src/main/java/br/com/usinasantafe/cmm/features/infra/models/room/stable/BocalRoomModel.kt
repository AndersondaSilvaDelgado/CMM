package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_BOCAL
import br.com.usinasantafe.cmm.features.domain.entities.stable.Bocal
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_BOCAL)
data class BocalRoomModel(
    @PrimaryKey val idBocal: Long,
    val codBocal: Long,
    val descrBocal: String
)

fun Bocal.toBocalModel(): BocalRoomModel{
    return with(this){
        BocalRoomModel(
            idBocal = this.idBocal,
            codBocal = this.codBocal,
            descrBocal = this.descrBocal
        )
    }
}

fun BocalRoomModel.toBocal(): Bocal {
    return with(this){
        Bocal(
            idBocal = this.idBocal,
            codBocal = this.codBocal,
            descrBocal = this.descrBocal
        )
    }
}
