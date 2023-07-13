package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.PressaoBocalRoomModel

interface PressaoBocalDatasourceRoom {

    suspend fun addAllPressaoBocal(vararg pressaoBocalRoomModels: PressaoBocalRoomModel)

    suspend fun deleteAllPressaoBocal()

}