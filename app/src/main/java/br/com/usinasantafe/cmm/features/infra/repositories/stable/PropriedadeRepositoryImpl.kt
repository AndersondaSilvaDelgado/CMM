package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Propriedade
import br.com.usinasantafe.cmm.features.infra.models.toPropriedade
import br.com.usinasantafe.cmm.features.infra.models.toPropriedadeModel
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
        for(propriedade in propriedadeList){
            val propriedadeModel = propriedade.toPropriedadeModel()
            propriedadeDatasourceRoom.addPropriedade(propriedadeModel)
        }
    }

    override suspend fun deleteAllPropriedade() {
        propriedadeDatasourceRoom.deleteAllPropriedade()
    }

    override suspend fun getAllPropriedade(): Flow<Result<List<Propriedade>>> {
        return flow {
            propriedadeDatasourceWebService.getAllPropriedade()
                .collect { result ->
                    result.onSuccess {propriedadeModelList ->
                        val propriedadeList = mutableListOf<Propriedade>()
                        for (propriedadeModel in propriedadeModelList){
                            propriedadeList.add(propriedadeModel.toPropriedade())
                        }
                        emit(Result.success(propriedadeList))
                    }
                }
        }
    }

}