package br.com.usinasantafe.cmm.features.domain.entities

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData

data class BoletimMMFert (
    var idBolMMFert: Long?,
    var tipoBolMMFert: Long?, //1 - Moto Mec; 2 - Fertirrigacao
    var matricFuncBolMMFert: Long?,
    var idEquipBolMMFert: Long?,
    var idEquipBombaBolMMFert: Long?,
    var idTurnoBolMMFert: Long?,
    var hodometroInicialBolMMFert: Double?,
    var hodometroFinalBolMMFert: Double?,
    var osBolMMFert: Long?,
    var ativPrincBolMMFert: Long?,
    var dthrInicialBolMMFert: String?,
    var dthrFinalBolMMFert: String?,
    var dthrFinalLongBolMMFert: Long?,
    var statusBolMMFert: StatusData,
    var statusConBolMMFert: StatusConnection?,  //0 - OffLine; 1 - OnLine
    var longitudeBolMMFert: Double?,
    var latitudeBolMMFert: Double?,
)