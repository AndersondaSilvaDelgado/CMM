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
        for(equip in equipList){
            val equipModel = equip.toEquipModel()
            equipDatasourceRoom.addEquip(equipModel)
        }
    }

    override suspend fun deleteAllEquip() {
        equipDatasourceRoom.deleteAllEquip()
    }

    override suspend fun getEquip(nroEquip: String): Flow<Result<List<Equip>>> {
        return flow {
            equipDatasourceWebService.getEquip(nroEquip)
                .collect { result ->
                    result.onSuccess { equipModelList ->
                        val equipList = mutableListOf<Equip>()
                        for (equipModel in equipModelList){
                            equipList.add(equipModel.toEquip())
                        }
                        emit(Result.success(equipList))
                    }
                }
        }
    }

}