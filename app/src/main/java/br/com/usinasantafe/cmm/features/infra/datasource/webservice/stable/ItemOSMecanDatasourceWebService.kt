package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemOSMecanRoomModel
import kotlinx.coroutines.flow.Flow

interface ItemOSMecanDatasourceWebService {

    suspend fun getAllItemOSMecan(): Flow<Result<List<ItemOSMecanRoomModel>>>

}