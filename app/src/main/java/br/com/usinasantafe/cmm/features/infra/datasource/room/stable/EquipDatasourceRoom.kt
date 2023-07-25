package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.room.stable.EquipRoomModel

interface EquipDatasourceRoom {

    suspend fun addAllEquip(vararg equipRoomModels: EquipRoomModel)

    suspend fun deleteAllEquip()

    suspend fun getEquip(): EquipRoomModel

    suspend fun hasEquip(): Boolean

    suspend fun updateHorimetroEquip(horimetro: Double): Boolean

}