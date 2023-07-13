package br.com.usinasantafe.cmm.features.infra.datasource.room.variable

import br.com.usinasantafe.cmm.features.infra.models.room.variable.ApontFertRoomModel

interface ApontFertDatasourceRoom {

    fun checkApontFertSend(): Boolean

    suspend fun insertApontFert(apontFertRoomModel: ApontFertRoomModel): Boolean

}