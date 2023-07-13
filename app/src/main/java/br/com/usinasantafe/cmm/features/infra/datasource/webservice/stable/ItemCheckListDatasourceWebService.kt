package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.ItemCheckListRoomModel
import kotlinx.coroutines.flow.Flow

interface ItemCheckListDatasourceWebService {

    suspend fun getAllItemCheckList(): Flow<Result<List<ItemCheckListRoomModel>>>

}