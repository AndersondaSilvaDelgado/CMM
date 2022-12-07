package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.EquipModel

interface EquipDatasourceRoom {

    suspend fun addAllEquip(vararg equipModels: EquipModel)

    suspend fun deleteAllEquip()

    suspend fun getEquipNro(nroEquip: Long): EquipModel

    suspend fun getEquipId(idEquip: Long): EquipModel

}