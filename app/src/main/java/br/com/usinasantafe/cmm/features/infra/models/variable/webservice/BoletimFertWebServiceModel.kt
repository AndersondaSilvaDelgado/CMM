package br.com.usinasantafe.cmm.features.infra.models.variable.webservice

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert
import kotlinx.serialization.Serializable

@Serializable
data class BoletimFertWebServiceModel(
    val idBolFert: Long,
    val matricFuncBolFert: Long,
    val idEquipBolFert: Long,
    val idEquipBombaBolMMFert: Long,
    val idTurnoBolFert: Long,
    val hodometroInicialBolFert: Double,
    val hodometroFinalBolFert: Double,
    val osBolFert: Long,
    val ativPrincBolFert: Long,
    val dthrInicialBolFert: String,
    var dthrFinalBolFert: String,
    val statusBolFert: Long,
    val statusConBolFert: Long,
    val longitudeBolFert: Double,
    val latitudeBolFert: Double
)
