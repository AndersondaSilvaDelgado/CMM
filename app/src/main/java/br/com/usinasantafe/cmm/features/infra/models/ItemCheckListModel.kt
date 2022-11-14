package br.com.usinasantafe.cmm.features.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.domain.entities.ItemCheckList
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbitemchecklistest")
data class ItemCheckListModel(
    @PrimaryKey val idItemCheckList: Long,
    val idCheckList: Long,
    val descrItemCheckList: String
)

fun ItemCheckList.toItemCheckListModel(): ItemCheckListModel{
    return with(this){
        ItemCheckListModel(
            idItemCheckList = this.idItemCheckList,
            idCheckList = this.idCheckList,
            descrItemCheckList = this.descrItemCheckList
        )
    }
}

fun ItemCheckListModel.toItemCheckList(): ItemCheckList {
    return with(this){
        ItemCheckList(
            idItemCheckList = this.idItemCheckList,
            idCheckList = this.idCheckList,
            descrItemCheckList = this.descrItemCheckList
        )
    }
}
