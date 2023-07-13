package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipPneuRoomModel
import kotlinx.coroutines.flow.Flow

interface REquipPneuDatasourceWebService {

    suspend fun getREquipPneu(nroEquip: String): Flow<Result<List<REquipPneuRoomModel>>>

}