package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Parada
import br.com.usinasantafe.cmm.features.infra.models.toParada
import br.com.usinasantafe.cmm.features.infra.models.toParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ParadaRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ParadaRepositoryImpl @Inject constructor(
    private val paradaDatasourceRoom: ParadaDatasourceRoom,
    private val paradaDatasourceWebService: ParadaDatasourceWebService
): ParadaRepository {

    override suspend fun addAllParada(paradaList: List<Parada>) {
        for(parada in paradaList){
            val paradaModel = parada.toParadaModel()
            paradaDatasourceRoom.addParada(paradaModel)
        }
    }

    override suspend fun deleteAllParada() {
        paradaDatasourceRoom.deleteAllParada()
    }

    override suspend fun getAllParada(): Flow<Result<List<Parada>>> {
        return flow {
            paradaDatasourceWebService.getAllParada()
                .collect { result ->
                    result.onSuccess {paradaModelList ->
                        val paradaList = mutableListOf<Parada>()
                        for (paradaModel in paradaModelList){
                            paradaList.add(paradaModel.toParada())
                        }
                        emit(Result.success(paradaList))
                    }
                }
        }
    }

}