package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_COMPONENTE
import br.com.usinasantafe.cmm.features.domain.entities.stable.Componente
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_COMPONENTE)
data class ComponenteRoomModel(
    @PrimaryKey val idComponente: Long,
    val codComponente: String,
    val descrComponente: String
)

fun Componente.toComponenteModel(): ComponenteRoomModel{
    return with(this){
        ComponenteRoomModel(
            idComponente = this.idComponente,
            codComponente = this.codComponente,
            descrComponente = this.descrComponente
        )
    }
}

fun ComponenteRoomModel.toComponente(): Componente {
    return with(this){
        Componente(
            idComponente = this.idComponente,
            codComponente = this.codComponente,
            descrComponente = this.descrComponente
        )
    }
}