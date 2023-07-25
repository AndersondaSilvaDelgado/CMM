package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.ConfigRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.EquipDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.EquipDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toEquip
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toEquipModel
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

    override suspend fun getEquip(): Equip {
        return equipDatasourceRoom.getEquip().toEquip()
    }

    override suspend fun hasEquip(): Boolean {
        return equipDatasourceRoom.hasEquip()
    }

    override suspend fun updateHorimetroEquip(horimetro: Double): Boolean {
        return equipDatasourceRoom.updateHorimetroEquip(horimetro)
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

}