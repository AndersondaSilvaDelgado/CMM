package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.EquipModel

interface EquipDatasourceDB {

    suspend fun addEquip(equipModel: EquipModel): Long

    suspend fun deleteAllEquip()

}