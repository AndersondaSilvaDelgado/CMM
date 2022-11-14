package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ComponenteModel

interface ComponenteDatasourceRoom {

    suspend fun addComponente(componenteModel: ComponenteModel): Long

    suspend fun deleteAllComponente()

}