package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Propriedade
import br.com.usinasantafe.cmm.features.infra.models.stable.toPropriedade
import br.com.usinasantafe.cmm.features.infra.models.stable.toPropriedadeModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.PropriedadeRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.PropriedadeDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.PropriedadeDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PropriedadeRepositoryImpl @Inject constructor(
    private val propriedadeDatasourceRoom: PropriedadeDatasourceRoom,
    private val propriedadeDatasourceWebService: PropriedadeDatasourceWebService
): PropriedadeRepository {

    override suspend fun addAllPropriedade(propriedadeList: List<Propriedade>) {
        propriedadeDatasourceRoom.addAllPropriedade(*propriedadeList.map { it.toPropriedadeModel() }.toTypedArray())
    }

    override suspend fun deleteAllPropriedade() {
        propriedadeDatasourceRoom.deleteAllPropriedade()
    }

    override suspend fun recoverAllPropriedade(): Flow<Result<List<Propriedade>>> {
        return flow {
            propriedadeDatasourceWebService.getAllPropriedade()
                .collect { result ->
                    result.onSuccess {propriedadeModelList ->
                        emit(Result.success(propriedadeModelList.map { it.toPropriedade() }))
                    }
                }
        }
    }

}