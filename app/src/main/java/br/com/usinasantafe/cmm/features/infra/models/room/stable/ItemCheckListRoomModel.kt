package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_ITEM_CHECKLIST
import br.com.usinasantafe.cmm.features.domain.entities.stable.ItemCheckList
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_ITEM_CHECKLIST)
data class ItemCheckListRoomModel(
    @PrimaryKey val idItemCheckList: Long,
    val idCheckList: Long,
    val descrItemCheckList: String
)

fun ItemCheckList.toItemCheckListModel(): ItemCheckListRoomModel{
    return with(this){
        ItemCheckListRoomModel(
            idItemCheckList = this.idItemCheckList,
            idCheckList = this.idCheckList,
            descrItemCheckList = this.descrItemCheckList
        )
    }
}

fun ItemCheckListRoomModel.toItemCheckList(): ItemCheckList {
    return with(this){
        ItemCheckList(
            idItemCheckList = this.idItemCheckList,
            idCheckList = this.idCheckList,
            descrItemCheckList = this.descrItemCheckList
        )
    }
}
