package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.MotoMecModel

interface MotoMecDatasourceDB {

    suspend fun addMotoMec(motoMecModel: MotoMecModel): Long

    suspend fun deleteAllMotoMec()

}