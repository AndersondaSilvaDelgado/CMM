package br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipAtivRoomModel
import kotlinx.coroutines.flow.Flow

interface REquipAtivDatasourceWebService {

    suspend fun getREquipAtiv(nroEquip: String): Flow<Result<List<REquipAtivRoomModel>>>

}