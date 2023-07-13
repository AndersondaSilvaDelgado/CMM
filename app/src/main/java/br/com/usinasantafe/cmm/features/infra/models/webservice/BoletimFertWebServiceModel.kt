package br.com.usinasantafe.cmm.features.infra.models.webservice

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class BoletimFertWebServiceModel(
    val idBolFert: Long,
    val matricFuncBolFert: Long,
    val idEquipBolFert: Long,
    val idEquipBombaBolMMFert: Long,
    val idTurnoBolFert: Long,
    val hodometroInicialBolFert: Double,
    val hodometroFinalBolFert: Double?,
    val nroOSBolFert: Long,
    val idAtivBolFert: Long,
    val dthrInicialBolFert: String,
    var dthrFinalBolFert: String,
    val statusBolFert: Long,
    val statusConBolFert: Long,
    val longitudeBolFert: Double,
    val latitudeBolFert: Double,
    val apontList: List<ApontFertWebServiceModel>,
)

fun BoletimFert.toBoletimFertWebServiceModel(): BoletimFertWebServiceModel {
    return with(this){
        BoletimFertWebServiceModel(
            idBolFert = this.idBol!!,
            matricFuncBolFert = this.matricFuncBol!!,
            idEquipBolFert = this.idEquipBol!!,
            idEquipBombaBolMMFert = this.idEquipBombaBol!!,
            idTurnoBolFert = this.idTurnoBol!!,
            hodometroInicialBolFert = this.hodometroInicialBol!!,
            hodometroFinalBolFert = this.hodometroFinalBol,
            nroOSBolFert = this.nroOSBol!!,
            idAtivBolFert = this.idAtivBol!!,
            dthrInicialBolFert = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).format(this.dthrInicialBol),
            dthrFinalBolFert = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).format(this.dthrFinalBol),
            statusBolFert = this.statusBol!!.ordinal.toLong(),
            statusConBolFert = this.statusConBol!!.ordinal.toLong(),
            longitudeBolFert = this.longitudeBol!!,
            latitudeBolFert = this.latitudeBol!!,
            apontList = this.apontList!!.map { it.toApontFertWebServiceModel() }
        )
    }
}
