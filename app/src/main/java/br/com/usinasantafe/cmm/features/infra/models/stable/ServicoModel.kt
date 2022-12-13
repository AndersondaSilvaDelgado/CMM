package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_SERVICO
import br.com.usinasantafe.cmm.features.domain.entities.stable.Servico
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_SERVICO)
data class ServicoModel(
    @PrimaryKey val idServico: Long,
    val codServico: Long,
    val descrServico: String
)

fun ServicoModel.toServico(): Servico {
    return with(this){
        Servico(
            idServico = this.idServico,
            codServico = this.codServico,
            descrServico = this.descrServico
        )
    }
}

fun Servico.toServicoModel(): ServicoModel{
    return with(this){
        ServicoModel(
            idServico = this.idServico,
            codServico = this.codServico,
            descrServico = this.descrServico
        )
    }
}