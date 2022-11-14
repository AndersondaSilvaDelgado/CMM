package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.RAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRAtivParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RAtivParadaRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.RAtivParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.RAtivParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RAtivParadaRepositoryImpl @Inject constructor(
    private val rAtivParadaDatasourceRoom: RAtivParadaDatasourceRoom,
    private val rAtivParadaDatasourceWebService: RAtivParadaDatasourceWebService
): RAtivParadaRepository {

    override suspend fun addAllRAtivParada(rAtivParadaList: List<RAtivParada>) {
        for(rAtivParada in rAtivParadaList){
            val rAtivParadaModel = rAtivParada.toRAtivParadaModel()
            rAtivParadaDatasourceRoom.addRAtivParada(rAtivParadaModel)
        }
    }

    override suspend fun deleteAllRAtivParada() {
        rAtivParadaDatasourceRoom.deleteAllRAtivParada()
    }

    override suspend fun getAllRAtivParada(): Flow<Result<List<RAtivParada>>> {
        return flow {
            rAtivParadaDatasourceWebService.getAllRAtivParada()
                .collect { result ->
                    result.onSuccess {rAtivParadaModelList ->
                        val rAtivParadaList = mutableListOf<RAtivParada>()
                        for (rAtivParadaModel in rAtivParadaModelList){
                            rAtivParadaList.add(rAtivParadaModel.toRAtivParada())
                        }
                        emit(Result.success(rAtivParadaList))
                    }
                }
        }
    }

}