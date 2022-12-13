package br.com.usinasantafe.cmm.features.infra.models.variable.webservice

import kotlinx.serialization.Serializable

@Serializable
data class BoletimMMWebServiceModel(
    val idBolMM: Long,
    val matricFuncBolMM: Long,
    val idEquipBolMM: Long,
    val idTurnoBolMM: Long,
    val hodometroInicialBolMM: String,
    val hodometroFinalBolMM: String,
    val osBolMM: Long,
    val ativPrincBolMM: Long,
    val dthrInicialBolMM: Long,
    val dthrFinalBolMM: Long,
    val statusBolMM: Long,
    val statusConBolMM: Long,
    val longitudeBolMM: Double,
    val latitudeBolMM: Double,
//    var apontList: List<ApontMM>? = emptyList(),
)
