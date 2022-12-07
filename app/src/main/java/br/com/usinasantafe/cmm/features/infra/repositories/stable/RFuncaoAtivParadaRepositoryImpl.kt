package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.RFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.RFuncaoAtivParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.RFuncaoAtivParadaDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toREquipPneuModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RFuncaoAtivParadaRepositoryImpl @Inject constructor(
    private val rFuncaoAtivParadaDatasourceRoom: RFuncaoAtivParadaDatasourceRoom,
    private val rFuncaoAtivParadaDatasourceWebService: RFuncaoAtivParadaDatasourceWebService
): RFuncaoAtivParadaRepository {

    override suspend fun addAllRFuncaoAtivParada(rFuncaoAtivParadaList: List<RFuncaoAtivParada>) {
        rFuncaoAtivParadaDatasourceRoom.addAllRFuncaoAtivParada(*rFuncaoAtivParadaList.map { it.toRFuncaoAtivParadaModel() }.toTypedArray())
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDatasourceRoom.deleteAllRFuncaoAtivParada()
    }

    override suspend fun recoverAllRFuncaoAtivParada(): Flow<Result<List<RFuncaoAtivParada>>> {
        return flow {
            rFuncaoAtivParadaDatasourceWebService.getAllRFuncaoAtivParada()
                .collect { result ->
                    result.onSuccess {rFuncaoAtivParadaModelList ->
                        emit(Result.success(rFuncaoAtivParadaModelList.map { it.toRFuncaoAtivParada() }))
                    }
                }
        }
    }

}