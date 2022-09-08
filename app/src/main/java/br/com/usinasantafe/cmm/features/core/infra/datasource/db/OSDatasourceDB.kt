package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.OSModel

interface OSDatasourceDB {

    suspend fun addOS(osModel: OSModel): Long

    suspend fun deleteAllOS()

}