package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.ItemCheckList
import kotlinx.coroutines.flow.Flow

interface ItemCheckListRepository {

    suspend fun addAllItemCheckList(itemCheckListList: List<ItemCheckList>)

    suspend fun deleteAllItemCheckList()

    suspend fun recoverAllItemCheckList(): Flow<Result<List<ItemCheckList>>>

}