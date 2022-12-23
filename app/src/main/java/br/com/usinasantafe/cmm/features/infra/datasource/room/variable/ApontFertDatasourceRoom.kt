package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontFertRoomModel

interface ApontFertDatasourceRoom {

    suspend fun insertApontFert(apontFertRoomModel: ApontFertRoomModel): Boolean

}