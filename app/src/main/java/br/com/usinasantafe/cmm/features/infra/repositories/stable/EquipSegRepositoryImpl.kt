package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.EquipSeg
import br.com.usinasantafe.cmm.features.infra.models.toEquipSeg
import br.com.usinasantafe.cmm.features.infra.models.toEquipSegModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipSegRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.EquipSegDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.EquipSegDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toEquipModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EquipSegRepositoryImpl @Inject constructor(
    private val equipSegDatasourceRoom: EquipSegDatasourceRoom,
    private val equipSegDatasourceWebService: EquipSegDatasourceWebService
): EquipSegRepository {

    override suspend fun addAllEquipSeg(equipSegList: List<EquipSeg>) {
        equipSegDatasourceRoom.addAllEquipSeg(*equipSegList.map { it.toEquipSegModel() }.toTypedArray())
    }

    override suspend fun deleteAllEquipSeg() {
        equipSegDatasourceRoom.deleteAllEquipSeg()
    }

    override suspend fun recoverAllEquipSeg(): Flow<Result<List<EquipSeg>>> {
        return flow {
            equipSegDatasourceWebService.getAllEquipSeg()
                .collect { result ->
                    result.onSuccess { equipSegModelList ->
                        emit(Result.success(equipSegModelList.map { it.toEquipSeg() }))
                    }
                }
        }
    }

}