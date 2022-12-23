package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.ItemCheckList
import br.com.usinasantafe.cmm.features.infra.models.stable.toItemCheckList
import br.com.usinasantafe.cmm.features.infra.models.stable.toItemCheckListModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ItemCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ItemCheckListDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemCheckListRepositoryImpl @Inject constructor(
    private val itemCheckListDatasourceRoom: ItemCheckListDatasourceRoom,
    private val itemCheckListDatasourceWebService: ItemCheckListDatasourceWebService
): ItemCheckListRepository {

    override suspend fun addAllItemCheckList(itemCheckListList: List<ItemCheckList>) {
        itemCheckListDatasourceRoom.addAllItemCheckList(*itemCheckListList.map { it.toItemCheckListModel() }.toTypedArray())
    }

    override suspend fun deleteAllItemCheckList() {
        itemCheckListDatasourceRoom.deleteAllItemCheckList()
    }

    override suspend fun recoverAllItemCheckList(): Flow<Result<List<ItemCheckList>>> {
        return flow {
            itemCheckListDatasourceWebService.getAllItemCheckList()
                .collect { result ->
                    result.onSuccess {itemCheckListModelList ->
                        emit(Result.success(itemCheckListModelList.map { it.toItemCheckList() }))
                    }
                }
        }
    }

}