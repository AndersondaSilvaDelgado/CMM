package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.EquipSegRoomModel

interface EquipSegDatasourceRoom {

    suspend fun addAllEquipSeg(vararg equipSegRoomModels: EquipSegRoomModel)

    suspend fun deleteAllEquipSeg()

}