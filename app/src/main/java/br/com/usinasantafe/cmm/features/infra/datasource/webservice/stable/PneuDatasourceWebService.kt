package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.PneuRoomModel
import kotlinx.coroutines.flow.Flow

interface PneuDatasourceWebService {

    suspend fun getAllPneu(): Flow<Result<List<PneuRoomModel>>>

}