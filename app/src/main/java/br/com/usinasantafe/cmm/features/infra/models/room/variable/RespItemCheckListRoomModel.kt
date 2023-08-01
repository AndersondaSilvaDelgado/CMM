package br.com.usinasantafe.cmm.features.infra.models.room.variable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList
import br.com.usinasantafe.cmm.common.utils.TB_RESP_ITEM_CHECK_LIST
import br.com.usinasantafe.cmm.features.domain.entities.variable.RespItemCheckList

@Entity(tableName = TB_RESP_ITEM_CHECK_LIST)
data class RespItemCheckListRoomModel(
    @PrimaryKey(autoGenerate = true)
    val idRespItemCheckList: Long? = null,
    val idItemRespItemCheckList: Long,
    val idCabecRespItemCheckList: Long,
    val opcaoRespItemCheckList: ChoiceCheckList,
)

fun RespItemCheckList.toRespItemCheckListRoomModel(): RespItemCheckListRoomModel{
    return with(this){
        RespItemCheckListRoomModel(
            idItemRespItemCheckList = this.idItemRespItemCheckList,
            idCabecRespItemCheckList = this.idCabecRespItemCheckList,
            opcaoRespItemCheckList = this.opcaoRespItemCheckList
        )
    }
}

fun RespItemCheckListRoomModel.toRespItemCheckList(): RespItemCheckList{
    return with(this){
        RespItemCheckList(
            idRespItemCheckList = this.idRespItemCheckList,
            idItemRespItemCheckList = this.idItemRespItemCheckList,
            idCabecRespItemCheckList = this.idCabecRespItemCheckList,
            opcaoRespItemCheckList = this.opcaoRespItemCheckList
        )
    }
}