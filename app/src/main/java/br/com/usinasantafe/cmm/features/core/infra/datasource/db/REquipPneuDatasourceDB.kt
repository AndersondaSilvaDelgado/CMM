package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.REquipPneuModel

interface REquipPneuDatasourceDB {

    suspend fun addREquipPneu(rEquipPneuModel: REquipPneuModel): Long

    suspend fun deleteAllREquipPneu()

}