package br.com.usinasantafe.cmm.features.core.infra.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Componente
import br.com.usinasantafe.cmm.features.core.infra.models.toComponente
import br.com.usinasantafe.cmm.features.core.infra.models.toComponenteModel
import br.com.usinasantafe.cmm.features.core.domain.repositories.ComponenteRepository
import br.com.usinasantafe.cmm.features.core.infra.datasource.db.ComponenteDatasourceDB
import br.com.usinasantafe.cmm.features.core.infra.datasource.web.ComponenteDatasourceWeb
import javax.inject.Inject

class ComponenteRepositoryImpl @Inject constructor(
    private val componenteDatasourceDB: ComponenteDatasourceDB,
    private val componenteDatasourceWeb: ComponenteDatasourceWeb
): ComponenteRepository {

    override suspend fun addAllComponente(componenteList: List<Componente>) {
        for(componente in componenteList){
            val componenteModel = componente.toComponenteModel()
            componenteDatasourceDB.addComponente(componenteModel)
        }
    }

    override suspend fun deleteAllComponente() {
        componenteDatasourceDB.deleteAllComponente()
    }

    override suspend fun getAllComponente(): List<Componente> {
        val componenteModelList = componenteDatasourceWeb.getAllComponente()
        val componenteList = mutableListOf<Componente>()
        for (componenteModel in componenteModelList){
            componenteList.add(componenteModel.toComponente())
        }
        return componenteList
    }

}