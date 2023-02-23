package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import br.com.usinasantafe.cmm.features.infra.models.stable.toParada
import br.com.usinasantafe.cmm.features.infra.models.stable.toParadaModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ParadaRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ParadaDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ParadaDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.stable.toAtividade
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

    override suspend fun listInIdParada(idParadas: List<Long>): List<Parada> {
        return paradaDatasourceRoom.listInIdParada(*idParadas.toLongArray()).map { it.toParada() }
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