package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.OSModel

interface OSDatasourceRoom {

    suspend fun addOS(osModel: OSModel): Long

    suspend fun deleteAllOS()

}