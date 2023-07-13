package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.OSRoomModel
import kotlinx.coroutines.flow.Flow

interface OSDatasourceWebService {

    suspend fun getAllOS(): Flow<Result<List<OSRoomModel>>>

    suspend fun recoverOS(nroOS: String): Flow<Result<List<OSRoomModel>>>

}