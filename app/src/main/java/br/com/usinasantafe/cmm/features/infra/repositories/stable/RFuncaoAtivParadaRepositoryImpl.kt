package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.RFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toRFuncaoAtivParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RFuncaoAtivParadaRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.RFuncaoAtivParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.RFuncaoAtivParadaDatasourceWebService
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

    override suspend fun checkImplementoIdAtiv(): Boolean {
        return rFuncaoAtivParadaDatasourceRoom.checkImplementoIdAtiv(boletimMMFertRepository.getIdAtivBoletimAberto())
    }

    override suspend fun deleteAllRFuncaoAtivParada() {
        rFuncaoAtivParadaDatasourceRoom.deleteAllRFuncaoAtivParada()
    }

    override suspend fun getParadaCheckList(): RFuncaoAtivParada {
        return rFuncaoAtivParadaDatasourceRoom.getParadaCheckList().toRFuncaoAtivParada()
    }

    override suspend fun listRFuncaoAtiv(): List<RFuncaoAtivParada> {
        return rFuncaoAtivParadaDatasourceRoom.listRFuncaoAtivIdAtiv(boletimMMFertRepository.getIdAtivBoletimAberto()).map { it.toRFuncaoAtivParada() }
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