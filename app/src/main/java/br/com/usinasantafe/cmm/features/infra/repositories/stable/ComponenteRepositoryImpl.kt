package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Componente
import br.com.usinasantafe.cmm.features.infra.models.toComponente
import br.com.usinasantafe.cmm.features.infra.models.toComponenteModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.ComponenteRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.ComponenteDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.ComponenteDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ComponenteRepositoryImpl @Inject constructor(
    private val componenteDatasourceRoom: ComponenteDatasourceRoom,
    private val componenteDatasourceWebService: ComponenteDatasourceWebService
): ComponenteRepository {

    override suspend fun addAllComponente(componenteList: List<Componente>) {
        for(componente in componenteList){
            val componenteModel = componente.toComponenteModel()
            componenteDatasourceRoom.addComponente(componenteModel)
        }
    }

    override suspend fun deleteAllComponente() {
        componenteDatasourceRoom.deleteAllComponente()
    }

    override suspend fun getAllComponente(): Flow<Result<List<Componente>>> {
        return flow {
            componenteDatasourceWebService.getAllComponente()
                .collect { result ->
                    result.onSuccess { componenteModelList ->
                        val componenteList = mutableListOf<Componente>()
                        for (componenteModel in componenteModelList){
                            componenteList.add(componenteModel.toComponente())
                        }
                        emit(Result.success(componenteList))
                    }
                }
        }
    }

}