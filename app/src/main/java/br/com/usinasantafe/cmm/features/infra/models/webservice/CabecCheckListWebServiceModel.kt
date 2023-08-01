package br.com.usinasantafe.cmm.features.infra.models.webservice

import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class CabecCheckListWebServiceModelOutput (
    val idCabecCheckList: Long,
    val nroEquipCabecCheckList: Long,
    val dtCabecCheckList: String,
    val matricFuncCabecCheckList: Long,
    val idTurnoCabecCheckList: Long,
    val respItemList: List<RespItemCheckListWebServiceModelOutput>,
)

@Serializable
data class CabecCheckListWebServiceModelInput (
    val idCabecCheckList: Long
)

fun CabecCheckList.toCabecCheckListWebServiceModel(): CabecCheckListWebServiceModelOutput {
    return with(this){
        CabecCheckListWebServiceModelOutput(
            idCabecCheckList = this.idCabecCheckList!!,
            nroEquipCabecCheckList = this.nroEquipCabecCheckList!!,
            dtCabecCheckList = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).format(this.dtCabecCheckList),
            matricFuncCabecCheckList = this.matricFuncCabecCheckList!!,
            idTurnoCabecCheckList = this.idTurnoCabecCheckList!!,
            respItemList = this.respItemList!!.map { it.toRespItemCheckListWebServiceModel() }
        )
    }
}

fun CabecCheckListWebServiceModelInput.toCabecCheckList(): CabecCheckList {
    return with(this){
        CabecCheckList(
            idCabecCheckList = this.idCabecCheckList
        )
    }
}
