package br.com.usinasantafe.cmm.features.infra.models.room.variable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.common.utils.TB_CABEC_CHECK_LIST
import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList
import java.util.*

@Entity(tableName = TB_CABEC_CHECK_LIST)
data class CabecCheckListRoomModel (
    @PrimaryKey(autoGenerate = true)
    val idCabecCheckList: Long? = null,
    val nroEquipCabecCheckList: Long,
    val dtCabecCheckList: Long,
    val matricFuncCabecCheckList: Long,
    val idTurnoCabecCheckList: Long,
    var statusData: StatusData = StatusData.OPEN,
    var statusSend: StatusSend = StatusSend.EMPTY
)

fun CabecCheckList.toCabecCheckListRoomModel(): CabecCheckListRoomModel{
    return with(this){
        CabecCheckListRoomModel(
            nroEquipCabecCheckList = this.nroEquipCabecCheckList,
            dtCabecCheckList = this.dtCabecCheckList.time,
            matricFuncCabecCheckList = this.matricFuncCabecCheckList,
            idTurnoCabecCheckList = this.idTurnoCabecCheckList
        )
    }
}

fun CabecCheckListRoomModel.toCabecCheckList(): CabecCheckList{
    return with(this){
        CabecCheckList(
            idCabecCheckList = this.idCabecCheckList,
            nroEquipCabecCheckList = this.nroEquipCabecCheckList,
            dtCabecCheckList = Date(this.dtCabecCheckList),
            matricFuncCabecCheckList = this.matricFuncCabecCheckList,
            idTurnoCabecCheckList = this.idTurnoCabecCheckList,
            statusData = this.statusData,
            statusSend = this.statusSend
        )
    }
}