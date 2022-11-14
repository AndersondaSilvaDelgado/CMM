package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.ItemOSMecan
import br.com.usinasantafe.cmm.features.infra.models.toItemOSMecan
import br.com.usinasantafe.cmm.features.infra.models.toItemOSMecanModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemOSMecanRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ItemOSMecanDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ItemOSMecanDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemOSMecanRepositoryImpl @Inject constructor(
    private val itemOSMecanDatasourceRoom: ItemOSMecanDatasourceRoom,
    private val itemOSMecanDatasourceWebService: ItemOSMecanDatasourceWebService
): ItemOSMecanRepository {

    override suspend fun addAllItemOSMecan(itemOSMecanList: List<ItemOSMecan>) {
        for(itemOSMecan in itemOSMecanList){
            val itemOSMecanModel = itemOSMecan.toItemOSMecanModel()
            itemOSMecanDatasourceRoom.addItemOSMecan(itemOSMecanModel)
        }
    }

    override suspend fun deleteAllItemOSMecan() {
        itemOSMecanDatasourceRoom.deleteAllItemOSMecan()
    }

    override suspend fun getAllItemOSMecan(): Flow<Result<List<ItemOSMecan>>> {
        return flow {
            itemOSMecanDatasourceWebService.getAllItemOSMecan()
                .collect { result ->
                    result.onSuccess {itemOSMecanModelList ->
                        val itemOSMecanList = mutableListOf<ItemOSMecan>()
                        for (itemOSMecanModel in itemOSMecanModelList){
                            itemOSMecanList.add(itemOSMecanModel.toItemOSMecan())
                        }
                        emit(Result.success(itemOSMecanList))
                    }
                }
        }
    }

}