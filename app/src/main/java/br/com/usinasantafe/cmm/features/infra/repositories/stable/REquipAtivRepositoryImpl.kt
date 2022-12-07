package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.REquipAtiv
import br.com.usinasantafe.cmm.features.domain.repositories.stable.REquipAtivRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.REquipAtivDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.REquipAtivDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toRAtivParadaModel
import br.com.usinasantafe.cmm.features.infra.models.toREquipAtiv
import br.com.usinasantafe.cmm.features.infra.models.toREquipAtivModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class REquipAtivRepositoryImpl @Inject constructor(
    private val rEquipAtivDatasourceRoom: REquipAtivDatasourceRoom,
    private val rEquipAtivDatasourceWebService: REquipAtivDatasourceWebService
): REquipAtivRepository {

    override suspend fun addAllREquipAtiv(rEquipAtivList: List<REquipAtiv>) {
        rEquipAtivDatasourceRoom.addAllREquipAtiv(*rEquipAtivList.map { it.toREquipAtivModel() }.toTypedArray())
    }

    override suspend fun deleteAllREquipAtiv() {
        rEquipAtivDatasourceRoom.deleteAllREquipAtiv()
    }

    override suspend fun recoverREquipAtiv(nroEquip: String): Flow<Result<List<REquipAtiv>>> {
        return flow {
            rEquipAtivDatasourceWebService.getREquipAtiv(nroEquip)
                .collect { result ->
                    result.onSuccess {rEquipAtivModelList ->
                        emit(Result.success(rEquipAtivModelList.map { it.toREquipAtiv() }))
                    }
                }
        }
    }

    override suspend fun listREquipAtiv(idEquip: Long): List<REquipAtiv> {
        return rEquipAtivDatasourceRoom.listREquipAtiv(idEquip).map { it.toREquipAtiv() }
    }

}