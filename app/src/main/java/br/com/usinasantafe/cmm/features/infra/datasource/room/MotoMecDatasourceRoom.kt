package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.stable.MotoMecModel

interface MotoMecDatasourceRoom {

    suspend fun addAllMotoMec(vararg motoMecModels: MotoMecModel)

    suspend fun deleteAllMotoMec()

}