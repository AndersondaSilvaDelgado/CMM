package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.FrenteModel

interface FrenteDatasourceDB {

    suspend fun addFrente(frenteModel: FrenteModel): Long

    suspend fun deleteAllFrente()

}