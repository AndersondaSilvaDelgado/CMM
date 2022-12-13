package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PRESSAO_BOCAL
import br.com.usinasantafe.cmm.features.domain.entities.stable.PressaoBocal
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PRESSAO_BOCAL)
data class PressaoBocalModel(
    @PrimaryKey val idPressaoBocal: Long,
    val idBocal: Long,
    val valorPressao: Double,
    val valorVeloc: Long
)

fun PressaoBocal.toPressaoBocalModel(): PressaoBocalModel{
    return with(this){
        PressaoBocalModel(
            idPressaoBocal = this.idPressaoBocal,
            idBocal = this.idBocal,
            valorPressao = this.valorPressao,
            valorVeloc = this.valorVeloc
        )
    }
}

fun PressaoBocalModel.toPressaoBocal(): PressaoBocal {
    return with(this){
        PressaoBocal(
            idPressaoBocal = this.idPressaoBocal,
            idBocal = this.idBocal,
            valorPressao = this.valorPressao,
            valorVeloc = this.valorVeloc
        )
    }
}
