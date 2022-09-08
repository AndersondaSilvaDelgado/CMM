package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.Componente
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbcomponenteest")
data class ComponenteModel(
    @PrimaryKey val idComponente: Long,
    val codComponente: Long,
    val descrComponente: String
)

fun Componente.toComponenteModel(): ComponenteModel{
    return with(this){
        ComponenteModel(
            idComponente = this.idComponente,
            codComponente = this.codComponente,
            descrComponente = this.descrComponente
        )
    }
}

fun ComponenteModel.toComponente(): Componente {
    return with(this){
        Componente(
            idComponente = this.idComponente,
            codComponente = this.codComponente,
            descrComponente = this.descrComponente
        )
    }
}