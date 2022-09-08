package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.Leira
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbleiraest")
data class LeiraModel(
    @PrimaryKey val idLeira: Long,
    val codLeira: Long,
    val statusLeira: Long
)

fun Leira.toLeiraModel(): LeiraModel{
    return with(this){
        LeiraModel(
            idLeira = this.idLeira,
            codLeira = this.codLeira,
            statusLeira = this.statusLeira
        )
    }
}

fun LeiraModel.toLeira(): Leira {
    return with(this){
        Leira(
            idLeira = this.idLeira,
            codLeira = this.codLeira,
            statusLeira = this.statusLeira
        )
    }
}
