package br.com.usinasantafe.cmm.features.infra.models.variable.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_MM
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import java.util.*

@Entity(tableName = TB_BOLETIM_MM)
data class BoletimMMRoomModel(
    @PrimaryKey(autoGenerate = true)
    val idBolMM: Long? = null,
    val matricFuncBolMM: Long,
    val idEquipBolMM: Long,
    val idTurnoBolMM: Long,
    val hodometroInicialBolMM: Double,
    val hodometroFinalBolMM: Double? = null,
    val nroOSBolMM: Long,
    val idAtivBolMM: Long,
    val dthrInicialBolMM: Long,
    val dthrFinalBolMM: Long,
    val statusBolMM: Long,
    val statusConBolMM: Long,
    val longitudeBolMM: Double,
    val latitudeBolMM: Double
)

fun BoletimMM.toBoletimMMRoomModel(): BoletimMMRoomModel{
    return with(this){
        BoletimMMRoomModel(
            matricFuncBolMM = this.matricFuncBol!!,
            idEquipBolMM = this.idEquipBol,
            idTurnoBolMM = this.idTurnoBol!!,
            hodometroInicialBolMM = this.hodometroInicialBol!!,
            nroOSBolMM = this.nroOSBol!!,
            idAtivBolMM = this.idAtivBol!!,
            dthrInicialBolMM = Date().time,
            dthrFinalBolMM = Date().time,
            statusBolMM = StatusData.ABERTO.ordinal.toLong(),
            statusConBolMM = StatusConnection.ONLINE.ordinal.toLong(),
            longitudeBolMM = 0.0,
            latitudeBolMM = 0.0
        )
    }
}

fun BoletimMMRoomModel.toBoletimMM(): BoletimMM{
    return with(this){
        BoletimMM(
            idBol = this.idBolMM,
            matricFuncBol = this.matricFuncBolMM,
            idEquipBol = this.idEquipBolMM,
            idTurnoBol = this.idTurnoBolMM,
            hodometroInicialBol = this.hodometroInicialBolMM,
            hodometroFinalBol = this.hodometroFinalBolMM,
            nroOSBol = this.nroOSBolMM,
            idAtivBol = this.idAtivBolMM,
            dthrInicialBol = Date(this.dthrInicialBolMM),
            dthrFinalBol = Date(this.dthrFinalBolMM),
            statusBol = StatusData.values()[this.statusBolMM.toInt()],
            statusConBol = StatusConnection.values()[this.statusConBolMM.toInt()],
            longitudeBol = this.longitudeBolMM,
            latitudeBol = this.latitudeBolMM,
        )
    }
}
