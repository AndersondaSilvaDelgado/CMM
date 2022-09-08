package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ComponenteModel

interface ComponenteDatasourceDB {

    suspend fun addComponente(componenteModel: ComponenteModel): Long

    suspend fun deleteAllComponente()

}