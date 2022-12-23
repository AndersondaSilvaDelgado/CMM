package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.OperMotoMecModel

interface OperMotoMecDatasourceRoom {

    suspend fun addAllOperMotoMec(vararg operMotoMecModels: OperMotoMecModel)

    suspend fun deleteAllOperMotoMec()

}