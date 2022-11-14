package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ItemOSMecanModel

interface ItemOSMecanDatasourceRoom {

    suspend fun addItemOSMecan(itemOSMecanModel: ItemOSMecanModel): Long

    suspend fun deleteAllItemOSMecan()

}