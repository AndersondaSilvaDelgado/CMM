package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_LEIRA
import br.com.usinasantafe.cmm.features.domain.entities.stable.Leira
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_LEIRA)
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
