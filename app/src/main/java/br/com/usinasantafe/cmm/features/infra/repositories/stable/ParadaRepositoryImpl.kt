package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Parada
import br.com.usinasantafe.cmm.features.infra.models.toParada
import br.com.usinasantafe.cmm.features.infra.models.toParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ParadaRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ParadaDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toOSModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ParadaRepositoryImpl @Inject constructor(
    private val paradaDatasourceRoom: ParadaDatasourceRoom,
    private val paradaDatasourceWebService: ParadaDatasourceWebService
): ParadaRepository {

    override suspend fun addAllParada(paradaList: List<Parada>) {
        paradaDatasourceRoom.addAllParada(*paradaList.map { it.toParadaModel() }.toTypedArray())
    }

    override suspend fun deleteAllParada() {
        paradaDatasourceRoom.deleteAllParada()
    }

    override suspend fun recoverAllParada(): Flow<Result<List<Parada>>> {
        return flow {
            paradaDatasourceWebService.getAllParada()
                .collect { result ->
                    result.onSuccess {paradaModelList ->
                        emit(Result.success(paradaModelList.map { it.toParada() }))
                    }
                }
        }
    }

}