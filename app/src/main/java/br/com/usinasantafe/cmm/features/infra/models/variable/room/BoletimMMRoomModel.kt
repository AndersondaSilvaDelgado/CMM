package br.com.usinasantafe.cmm.features.infra.models.variable.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_MM
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import java.util.*

@Entity(tableName = TB_BOLETIM_MM)
data class BoletimMMModel(
    @PrimaryKey(autoGenerate = true)
    val idBolMM: Long? = null,
    val matricFuncBolMM: Long,
    val idEquipBolMM: Long,
    val idTurnoBolMM: Long,
    val hodometroInicialBolMM: Double,
    val hodometroFinalBolMM: Double? = null,
    val osBolMM: Long,
    val ativPrincBolMM: Long,
    val dthrInicialBolMM: Long,
    val dthrFinalBolMM: Long? = null,
    val statusBolMM: Long,
    val statusConBolMM: Long,
    val longitudeBolMM: Double,
    val latitudeBolMM: Double
)

fun BoletimMM.toBoletimMMModel(): BoletimMMModel{
    return with(this){
        BoletimMMModel(
            matricFuncBolMM = this.matricFuncBol!!,
            idEquipBolMM = this.idEquipBol!!,
            idTurnoBolMM = this.idTurnoBol!!,
            hodometroInicialBolMM = this.hodometroInicialBol!!,
            osBolMM = this.osBol!!,
            ativPrincBolMM = this.ativPrincBol!!,
            dthrInicialBolMM = Date().time,
            statusBolMM = StatusData.ABERTO.ordinal.toLong(),
            statusConBolMM = StatusConnection.ONLINE.ordinal.toLong(),
            longitudeBolMM = 0.0,
            latitudeBolMM = 0.0
        )
    }
}
