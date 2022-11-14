package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.EquipSeg
import br.com.usinasantafe.cmm.features.infra.models.toEquipSeg
import br.com.usinasantafe.cmm.features.infra.models.toEquipSegModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipSegRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.EquipSegDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.EquipSegDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EquipSegRepositoryImpl @Inject constructor(
    private val equipSegDatasourceRoom: EquipSegDatasourceRoom,
    private val equipSegDatasourceWebService: EquipSegDatasourceWebService
): EquipSegRepository {

    override suspend fun addAllEquipSeg(equipSegList: List<EquipSeg>) {
        for(equipSeg in equipSegList){
            val equipSegModel = equipSeg.toEquipSegModel()
            equipSegDatasourceRoom.addEquipSeg(equipSegModel)
        }
    }

    override suspend fun deleteAllEquipSeg() {
        equipSegDatasourceRoom.deleteAllEquipSeg()
    }

    override suspend fun getAllEquipSeg(): Flow<Result<List<EquipSeg>>> {
        return flow {
            equipSegDatasourceWebService.getAllEquipSeg()
                .collect { result ->
                    result.onSuccess { equipSegModelList ->
                        val equipSegList = mutableListOf<EquipSeg>()
                        for (equipSegModel in equipSegModelList){
                            equipSegList.add(equipSegModel.toEquipSeg())
                        }
                        emit(Result.success(equipSegList))
                    }
                }
        }
    }

}