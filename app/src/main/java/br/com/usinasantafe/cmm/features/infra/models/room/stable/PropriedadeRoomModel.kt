package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PROPRIEDADE
import br.com.usinasantafe.cmm.features.domain.entities.stable.Propriedade
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PROPRIEDADE)
data class PropriedadeRoomModel(
    @PrimaryKey val idPropriedade: Long,
    val codPropriedade: Long,
    val descrPropriedade: String
)

fun Propriedade.toPropriedadeModel(): PropriedadeRoomModel{
    return with(this){
        PropriedadeRoomModel(
            idPropriedade = this.idPropriedade,
            codPropriedade = this.codPropriedade,
            descrPropriedade = this.descrPropriedade
        )
    }
}

fun PropriedadeRoomModel.toPropriedade(): Propriedade {
    return with(this){
        Propriedade(
            idPropriedade = this.idPropriedade,
            codPropriedade = this.codPropriedade,
            descrPropriedade = this.descrPropriedade
        )
    }
}
