package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.OSModel

interface OSDatasourceRoom {

    suspend fun addAllOS(vararg osModels: OSModel)

    suspend fun deleteAllOS()

    suspend fun checkOS(nroOS: Long): Boolean

    suspend fun getOSNro(nroOS: Long): OSModel

}