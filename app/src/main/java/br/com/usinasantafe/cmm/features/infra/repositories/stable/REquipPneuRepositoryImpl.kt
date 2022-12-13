package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.REquipPneu
import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipPneuRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.REquipPneuDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.REquipPneuDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.stable.toREquipPneu
import br.com.usinasantafe.cmm.features.infra.models.stable.toREquipPneuModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class REquipPneuRepositoryImpl @Inject constructor(
    private val rEquipPneuDatasourceRoom: REquipPneuDatasourceRoom,
    private val rEquipPneuDatasourceWebService: REquipPneuDatasourceWebService
): REquipPneuRepository {

    override suspend fun addAllREquipPneu(rEquipPneuList: List<REquipPneu>) {
        rEquipPneuDatasourceRoom.addAllREquipPneu(*rEquipPneuList.map { it.toREquipPneuModel() }.toTypedArray())
    }

    override suspend fun deleteAllREquipPneu() {
        rEquipPneuDatasourceRoom.deleteAllREquipPneu()
    }

    override suspend fun recoverREquipPneu(nroEquip: String): Flow<Result<List<REquipPneu>>> {
        return flow {
            rEquipPneuDatasourceWebService.getREquipPneu(nroEquip)
                .collect { result ->
                    result.onSuccess {rEquipPneuModelList ->
                        emit(Result.success(rEquipPneuModelList.map { it.toREquipPneu() }))
                    }
                }
        }
    }

}