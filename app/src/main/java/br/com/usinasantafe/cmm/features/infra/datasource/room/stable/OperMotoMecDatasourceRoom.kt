package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.OperMotoMecRoomModel

interface OperMotoMecDatasourceRoom {

    suspend fun addAllOperMotoMec(vararg operMotoMecRoomModels: OperMotoMecRoomModel)

    suspend fun deleteAllOperMotoMec()

}