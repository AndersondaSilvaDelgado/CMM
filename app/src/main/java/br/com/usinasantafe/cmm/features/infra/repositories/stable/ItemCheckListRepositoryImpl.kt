package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.ItemCheckList
import br.com.usinasantafe.cmm.features.infra.models.toItemCheckList
import br.com.usinasantafe.cmm.features.infra.models.toItemCheckListModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemCheckListRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ItemCheckListDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ItemCheckListDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemCheckListRepositoryImpl @Inject constructor(
    private val itemCheckListDatasourceRoom: ItemCheckListDatasourceRoom,
    private val itemCheckListDatasourceWebService: ItemCheckListDatasourceWebService
): ItemCheckListRepository {

    override suspend fun addAllItemCheckList(itemCheckListList: List<ItemCheckList>) {
        for(itemCheckList in itemCheckListList){
            val itemCheckListModel = itemCheckList.toItemCheckListModel()
            itemCheckListDatasourceRoom.addItemCheckList(itemCheckListModel)
        }
    }

    override suspend fun deleteAllItemCheckList() {
        itemCheckListDatasourceRoom.deleteAllItemCheckList()
    }

    override suspend fun getAllItemCheckList(): Flow<Result<List<ItemCheckList>>> {
        return flow {
            itemCheckListDatasourceWebService.getAllItemCheckList()
                .collect { result ->
                    result.onSuccess {itemCheckListModelList ->
                        val itemCheckListList = mutableListOf<ItemCheckList>()
                        for (itemCheckListModel in itemCheckListModelList){
                            itemCheckListList.add(itemCheckListModel.toItemCheckList())
                        }
                        emit(Result.success(itemCheckListList))
                    }
                }
        }
    }

}