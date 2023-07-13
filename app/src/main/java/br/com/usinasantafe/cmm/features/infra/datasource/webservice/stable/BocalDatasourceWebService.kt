package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.BocalRoomModel
import kotlinx.coroutines.flow.Flow

interface BocalDatasourceWebService {

    suspend fun getAllBocal(): Flow<Result<List<BocalRoomModel>>>

}