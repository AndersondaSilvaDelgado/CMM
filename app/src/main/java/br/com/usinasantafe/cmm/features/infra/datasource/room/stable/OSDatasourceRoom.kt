package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.OSRoomModel

interface OSDatasourceRoom {

    suspend fun addAllOS(vararg osRoomModels: OSRoomModel)

    suspend fun deleteAllOS()

    suspend fun checkOS(nroOS: Long): Boolean

    suspend fun getOSNro(nroOS: Long): OSRoomModel

}