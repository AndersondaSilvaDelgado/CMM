package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.Propriedade
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbpropriedadeest")
data class PropriedadeModel(
    @PrimaryKey val idPropriedade: Long,
    val codPropriedade: Long,
    val descrPropriedade: String
)

fun Propriedade.toPropriedadeModel(): PropriedadeModel{
    return with(this){
        PropriedadeModel(
            idPropriedade = this.idPropriedade,
            codPropriedade = this.codPropriedade,
            descrPropriedade = this.descrPropriedade
        )
    }
}

fun PropriedadeModel.toPropriedade(): Propriedade {
    return with(this){
        Propriedade(
            idPropriedade = this.idPropriedade,
            codPropriedade = this.codPropriedade,
            descrPropriedade = this.descrPropriedade
        )
    }
}
