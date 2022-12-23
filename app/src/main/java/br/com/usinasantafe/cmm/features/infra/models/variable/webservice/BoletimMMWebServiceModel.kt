package br.com.usinasantafe.cmm.features.infra.models.variable.webservice

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class BoletimMMWebServiceModel(
    val idBolMM: Long,
    val matricFuncBolMM: Long,
    val idEquipBolMM: Long,
    val idTurnoBolMM: Long,
    val hodometroInicialBolMM: Double,
    val hodometroFinalBolMM: Double?,
    val nroOSBolMM: Long,
    val idAtivBolMM: Long,
    val dthrInicialBolMM: String,
    val dthrFinalBolMM: String,
    val statusBolMM: Long,
    val statusConBolMM: Long,
    val longitudeBolMM: Double,
    val latitudeBolMM: Double,
    val apontList: List<ApontMMWebServiceModel>,
)

fun BoletimMM.toBoletimMMWebServiceModel(): BoletimMMWebServiceModel {
    return with(this){
        BoletimMMWebServiceModel(
            idBolMM = this.idBol!!,
            matricFuncBolMM = this.matricFuncBol!!,
            idEquipBolMM = this.idEquipBol,
            idTurnoBolMM = this.idTurnoBol!!,
            hodometroInicialBolMM = this.hodometroInicialBol!!,
            hodometroFinalBolMM = this.hodometroFinalBol,
            nroOSBolMM = this.nroOSBol!!,
            idAtivBolMM = this.idAtivBol!!,
            dthrInicialBolMM = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).format(this.dthrInicialBol),
            dthrFinalBolMM = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).format(this.dthrFinalBol),
            statusBolMM = this.statusBol.ordinal.toLong(),
            statusConBolMM = this.statusConBol!!.ordinal.toLong(),
            longitudeBolMM = this.longitudeBol!!,
            latitudeBolMM = this.latitudeBol!!,
            apontList = this.apontList!!.map { it.toApontMMWebServiceModel() }
        )
    }
}


