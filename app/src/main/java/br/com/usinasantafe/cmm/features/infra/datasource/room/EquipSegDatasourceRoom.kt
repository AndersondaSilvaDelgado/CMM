package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.EquipSegModel

interface EquipSegDatasourceRoom {

    suspend fun addEquipSeg(equipSegModel: EquipSegModel): Long

    suspend fun deleteAllEquipSeg()

}