package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.MotoMecModel

interface MotoMecDatasourceRoom {

    suspend fun addMotoMec(motoMecModel: MotoMecModel): Long

    suspend fun deleteAllMotoMec()

}