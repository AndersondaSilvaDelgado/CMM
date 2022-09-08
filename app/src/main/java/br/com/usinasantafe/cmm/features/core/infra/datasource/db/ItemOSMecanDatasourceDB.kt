package br.com.usinasantafe.cmm.features.core.infra.datasource.db

import br.com.usinasantafe.cmm.features.core.infra.models.ItemOSMecanModel

interface ItemOSMecanDatasourceDB {

    suspend fun addItemOSMecan(itemOSMecanModel: ItemOSMecanModel): Long

    suspend fun deleteAllItemOSMecan()

}