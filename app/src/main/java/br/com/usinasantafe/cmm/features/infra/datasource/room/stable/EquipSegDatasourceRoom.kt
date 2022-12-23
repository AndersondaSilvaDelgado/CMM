package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.EquipSegModel

interface EquipSegDatasourceRoom {

    suspend fun addAllEquipSeg(vararg equipSegModels: EquipSegModel)

    suspend fun deleteAllEquipSeg()

}