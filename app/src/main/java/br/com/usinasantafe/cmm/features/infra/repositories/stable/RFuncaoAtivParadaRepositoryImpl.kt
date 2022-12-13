package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.RFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.stable.toRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.stable.toRFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.RFuncaoAtivParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.RFuncaoAtivParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RFuncaoAtivParadaRepositoryImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
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

    override suspend fun listRFuncaoAtiv(): List<RFuncaoAtivParada> {
        return rFuncaoAtivParadaDatasourceRoom.listRFuncaoAtiv(boletimMMFertRepository.getAtiv()).map { it.toRFuncaoAtivParada() }
    }

}