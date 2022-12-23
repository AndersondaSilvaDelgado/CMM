package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.ItemOSMecanModel

interface ItemOSMecanDatasourceRoom {

    suspend fun addAllItemOSMecan(vararg itemOSMecanModels: ItemOSMecanModel)

    suspend fun deleteAllItemOSMecan()

}