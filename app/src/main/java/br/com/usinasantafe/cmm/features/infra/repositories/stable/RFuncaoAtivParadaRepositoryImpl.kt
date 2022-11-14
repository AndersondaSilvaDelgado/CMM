package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.RFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.RFuncaoAtivParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.RFuncaoAtivParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RFuncaoAtivParadaRepositoryImpl @Inject constructor(
    private val rFuncaoAtivParadaDatasourceRoom: RFuncaoAtivParadaDatasourceRoom,
    private val rFuncaoAtivParadaDatasourceWebService: RFuncaoAtivParadaDatasourceWebService
): RFuncaoAtivParadaRepository {

    override suspend fun addAllRFuncaoAtivParada(rFuncaoAtivParadaList: List<RFuncaoAtivParada>) {
        for(rFuncaoAtivParada in rFuncaoAtivParadaList){
            val rFuncaoAtivParadaModel = rFuncaoAtivParada.toRFuncaoAtivParadaModel()
            rFuncaoAtivParadaDatasourceRoom.addRFuncaoAtivParada(rFuncaoAtivParadaModel)
        }
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDatasourceRoom.deleteAllRFuncaoAtivParada()
    }

    override suspend fun getAllRFuncaoAtivParada(): Flow<Result<List<RFuncaoAtivParada>>> {
        return flow {
            rFuncaoAtivParadaDatasourceWebService.getAllRFuncaoAtivParada()
                .collect { result ->
                    result.onSuccess {rFuncaoAtivParadaModelList ->
                        val rFuncaoAtivParadaList = mutableListOf<RFuncaoAtivParada>()
                        for (rFuncaoAtivParadaModel in rFuncaoAtivParadaModelList){
                            rFuncaoAtivParadaList.add(rFuncaoAtivParadaModel.toRFuncaoAtivParada())
                        }
                        emit(Result.success(rFuncaoAtivParadaList))
                    }
                }
        }
    }

}