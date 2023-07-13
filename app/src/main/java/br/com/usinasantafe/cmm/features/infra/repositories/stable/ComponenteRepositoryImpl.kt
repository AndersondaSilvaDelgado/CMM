package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Componente
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toComponente
import br.com.usinasantafe.cmm.features.infra.models.room.stable.toComponenteModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ComponenteRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.ComponenteDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ComponenteDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ComponenteRepositoryImpl @Inject constructor(
    private val componenteDatasourceRoom: ComponenteDatasourceRoom,
    private val componenteDatasourceWebService: ComponenteDatasourceWebService
): ComponenteRepository {

    override suspend fun addAllComponente(componenteList: List<Componente>) {
        componenteDatasourceRoom.addAllComponente(*componenteList.map { it.toComponenteModel() }.toTypedArray())
    }

    override suspend fun deleteAllComponente() {
        componenteDatasourceRoom.deleteAllComponente()
    }

    override suspend fun recoverAllComponente(): Flow<Result<List<Componente>>> {
        return flow {
            componenteDatasourceWebService.getAllComponente()
                .collect { result ->
                    result.onSuccess { componenteModelList ->
                        emit(Result.success(componenteModelList.map { it.toComponente() }))
                    }
                }
        }
    }

}