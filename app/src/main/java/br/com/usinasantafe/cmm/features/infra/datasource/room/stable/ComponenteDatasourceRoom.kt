package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ComponenteRoomModel

interface ComponenteDatasourceRoom {

    suspend fun addAllComponente(vararg componenteRoomModels: ComponenteRoomModel)

    suspend fun deleteAllComponente()

}