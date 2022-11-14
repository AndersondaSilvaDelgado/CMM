package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.EquipModel

interface EquipDatasourceRoom {

    suspend fun addEquip(equipModel: EquipModel): Long

    suspend fun deleteAllEquip()

}