package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.PneuRoomModel

interface PneuDatasourceRoom {

    suspend fun addAllPneu(vararg pneuRoomModels: PneuRoomModel)

    suspend fun deleteAllPneu()

}