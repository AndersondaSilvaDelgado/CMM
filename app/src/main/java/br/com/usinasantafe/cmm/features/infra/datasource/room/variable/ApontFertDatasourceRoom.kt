package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontFertRoomModel

interface ApontFertDatasourceRoom {

    fun checkApontFertSend(): Boolean

    suspend fun insertApontFert(apontFertRoomModel: ApontFertRoomModel): Boolean

}