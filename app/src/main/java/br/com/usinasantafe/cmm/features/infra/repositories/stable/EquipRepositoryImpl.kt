package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Equip
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.EquipDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.EquipDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toEquip
import br.com.usinasantafe.cmm.features.infra.models.toEquipModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EquipRepositoryImpl @Inject constructor(
    private val equipDatasourceRoom: EquipDatasourceRoom,
    private val equipDatasourceWebService: EquipDatasourceWebService
): EquipRepository {

    override suspend fun addAllEquip(equipList: List<Equip>) {
        equipDatasourceRoom.addAllEquip(*equipList.map { it.toEquipModel() }.toTypedArray())
    }

    override suspend fun deleteAllEquip() {
        equipDatasourceRoom.deleteAllEquip()
    }

    override suspend fun recoverEquip(nroEquip: String): Flow<Result<List<Equip>>> {
        return flow {
            equipDatasourceWebService.getEquip(nroEquip)
                .collect { result ->
                    result.onSuccess { equipModelList ->
                        emit(Result.success(equipModelList.map { it.toEquip() }))
                    }
                }
        }
    }

    override suspend fun getEquipNro(nroEquip: Long): Equip {
        return equipDatasourceRoom.getEquipNro(nroEquip).toEquip()
    }

    override suspend fun getEquipId(idEquip: Long): Equip {
        return equipDatasourceRoom.getEquipId(idEquip).toEquip()
    }

}