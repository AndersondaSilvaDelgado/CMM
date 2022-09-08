package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.EquipSegModel

interface EquipSegDatasourceDB {

    suspend fun addEquipSeg(equipSegModel: EquipSegModel): Long

    suspend fun deleteAllEquipSeg()

}