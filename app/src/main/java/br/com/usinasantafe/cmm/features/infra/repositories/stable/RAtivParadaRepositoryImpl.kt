package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.RAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRAtivParada
import br.com.usinasantafe.cmm.features.infra.models.toRAtivParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.RAtivParadaRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.RAtivParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.RAtivParadaDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toPropriedadeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RAtivParadaRepositoryImpl @Inject constructor(
    private val rAtivParadaDatasourceRoom: RAtivParadaDatasourceRoom,
    private val rAtivParadaDatasourceWebService: RAtivParadaDatasourceWebService
): RAtivParadaRepository {

    override suspend fun addAllRAtivParada(rAtivParadaList: List<RAtivParada>) {
        rAtivParadaDatasourceRoom.addAllRAtivParada(*rAtivParadaList.map { it.toRAtivParadaModel() }.toTypedArray())
    }

    override suspend fun deleteAllRAtivParada() {
        rAtivParadaDatasourceRoom.deleteAllRAtivParada()
    }

    override suspend fun recoverAllRAtivParada(): Flow<Result<List<RAtivParada>>> {
        return flow {
            rAtivParadaDatasourceWebService.getAllRAtivParada()
                .collect { result ->
                    result.onSuccess {rAtivParadaModelList ->
                        emit(Result.success(rAtivParadaModelList.map { it.toRAtivParada() }))
                    }
                }
        }
    }

}