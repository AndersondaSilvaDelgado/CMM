package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.ItemCheckList

interface ItemCheckListRepository {

    suspend fun addAllItemCheckList(itemCheckListList: List<ItemCheckList>)

    suspend fun deleteAllItemCheckList()

    suspend fun getAllItemCheckList(): List<ItemCheckList>

}