package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.REquipAtivRoomModel

interface REquipAtivDatasourceRoom {

    suspend fun addAllREquipAtiv(vararg rEquipAtivRoomModels: REquipAtivRoomModel)

    suspend fun deleteAllREquipAtiv()

    suspend fun listREquipAtiv(idEquip: Long): List<REquipAtivRoomModel>

}