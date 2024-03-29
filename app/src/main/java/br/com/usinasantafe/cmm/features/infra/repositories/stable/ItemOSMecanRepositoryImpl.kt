package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.ItemOSMecan
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toItemOSMecan
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toItemOSMecanModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemOSMecanRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ItemOSMecanDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ItemOSMecanDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemOSMecanRepositoryImpl @Inject constructor(
    private val itemOSMecanDatasourceRoom: ItemOSMecanDatasourceRoom,
    private val itemOSMecanDatasourceWebService: ItemOSMecanDatasourceWebService
): ItemOSMecanRepository {

    override suspend fun addAllItemOSMecan(itemOSMecanList: List<ItemOSMecan>) {
        itemOSMecanDatasourceRoom.addAllItemOSMecan(*itemOSMecanList.map { it.toItemOSMecanModel() }.toTypedArray())
    }

    override suspend fun deleteAllItemOSMecan() {
        itemOSMecanDatasourceRoom.deleteAllItemOSMecan()
    }

    override suspend fun recoverAllItemOSMecan(): Flow<Result<List<ItemOSMecan>>> {
        return flow {
            itemOSMecanDatasourceWebService.getAllItemOSMecan()
                .collect { result ->
                    result.onSuccess {itemOSMecanModelList ->
                        emit(Result.success(itemOSMecanModelList.map { it.toItemOSMecan() }))
                    }
                }
        }
    }

}