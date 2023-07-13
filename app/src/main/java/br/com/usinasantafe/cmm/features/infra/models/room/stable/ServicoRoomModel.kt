package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_SERVICO
import br.com.usinasantafe.cmm.features.domain.entities.stable.Servico
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_SERVICO)
data class ServicoRoomModel(
    @PrimaryKey val idServico: Long,
    val codServico: Long,
    val descrServico: String
)

fun ServicoRoomModel.toServico(): Servico {
    return with(this){
        Servico(
            idServico = this.idServico,
            codServico = this.codServico,
            descrServico = this.descrServico
        )
    }
}

fun Servico.toServicoModel(): ServicoRoomModel{
    return with(this){
        ServicoRoomModel(
            idServico = this.idServico,
            codServico = this.codServico,
            descrServico = this.descrServico
        )
    }
}