package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ComponenteModel

interface ComponenteDatasourceRoom {

    suspend fun addAllComponente(vararg componenteModels: ComponenteModel)

    suspend fun deleteAllComponente()

}