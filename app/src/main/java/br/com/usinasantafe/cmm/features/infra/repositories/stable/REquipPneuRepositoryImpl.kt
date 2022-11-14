package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.REquipPneu
import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipPneuRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.REquipPneuDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.REquipPneuDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toREquipPneu
import br.com.usinasantafe.cmm.features.infra.models.toREquipPneuModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class REquipPneuRepositoryImpl @Inject constructor(
    private val rEquipPneuDatasourceRoom: REquipPneuDatasourceRoom,
    private val rEquipPneuDatasourceWebService: REquipPneuDatasourceWebService
): REquipPneuRepository {

    override suspend fun addAllREquipPneu(rEquipPneuList: List<REquipPneu>) {
        for(rEquipPneu in rEquipPneuList){
            val rEquipPneuModel = rEquipPneu.toREquipPneuModel()
            rEquipPneuDatasourceRoom.addREquipPneu(rEquipPneuModel)
        }
    }

    override suspend fun deleteAllREquipPneu() {
        rEquipPneuDatasourceRoom.deleteAllREquipPneu()
    }

    override suspend fun getREquipPneu(nroEquip: String): Flow<Result<List<REquipPneu>>> {
        return flow {
            rEquipPneuDatasourceWebService.getREquipPneu(nroEquip)
                .collect { result ->
                    result.onSuccess {rEquipPneuModelList ->
                        val rEquipPneuList = mutableListOf<REquipPneu>()
                        for (rEquipPneuModel in rEquipPneuModelList){
                            rEquipPneuList.add(rEquipPneuModel.toREquipPneu())
                        }
                        emit(Result.success(rEquipPneuList))
                    }
                }
        }
    }

}