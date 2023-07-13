package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_OS
import br.com.usinasantafe.cmm.features.domain.entities.stable.OS
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_OS)
data class OSRoomModel(
    @PrimaryKey val idOS: Long,
    val nroOS: Long,
    val idLibOS: Long?,
    val idProprAgr: Long?,
    val areaProgrOS: Double?,
    val tipoOS: Long?,
    val idEquip: Long?
)

fun OS.toOSModel(): OSRoomModel{
    return with(this){
        OSRoomModel(
            idOS = this.idOS,
            nroOS = this.nroOS,
            idLibOS = this.idLibOS,
            idProprAgr = this.idProprAgr,
            areaProgrOS = this.areaProgrOS,
            tipoOS = this.tipoOS
            ,
            idEquip = this.idEquip
        )
    }
}

fun OSRoomModel.toOS(): OS {
    return with(this){
        OS(
            idOS = this.idOS,
            nroOS = this.nroOS,
            idLibOS = this.idLibOS,
            idProprAgr = this.idProprAgr,
            areaProgrOS = this.areaProgrOS,
            tipoOS = this.tipoOS
            ,
            idEquip = this.idEquip
        )
    }
}
