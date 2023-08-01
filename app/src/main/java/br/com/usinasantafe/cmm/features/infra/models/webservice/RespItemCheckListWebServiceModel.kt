package br.com.usinasantafe.cmm.features.infra.models.webservice

import br.com.usinasantafe.cmm.features.domain.entities.variable.RespItemCheckList
import java.text.SimpleDateFormat
import java.util.*

data class RespItemCheckListWebServiceModelOutput(
    val idItemRespItemCheckList: Long,
    val opcaoRespItemCheckList: Long,
)

fun RespItemCheckList.toRespItemCheckListWebServiceModel(): RespItemCheckListWebServiceModelOutput {
    return with(this){
        RespItemCheckListWebServiceModelOutput(
            idItemRespItemCheckList = this.idItemRespItemCheckList!!,
            opcaoRespItemCheckList = opcaoRespItemCheckList!!.ordinal.toLong()
        )
    }
}