package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.LeiraRoomModel
import kotlinx.coroutines.flow.Flow

interface LeiraDatasourceWebService {

    suspend fun getAllLeira(): Flow<Result<List<LeiraRoomModel>>>

}