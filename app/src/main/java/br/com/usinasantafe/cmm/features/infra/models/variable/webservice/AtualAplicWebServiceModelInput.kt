package br.com.usinasantafe.cmm.features.infra.models.variable.webservice

import kotlinx.serialization.Serializable

@Serializable
data class AtualAplicWebServiceModelInput(
    var idEquipAtual: Long,
    var idCheckList: Long,
    var versaoAtual: String,
    var versaoNova: String,
    var flagAtualApp: Long,
    var flagAtualCheckList: Long,
    var dthr: String,
)

@Serializable
data class AtualAplicWebServiceModelOutput(
    var idEquipAtual: Long,
    var versaoAtual: String,
)

