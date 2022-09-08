package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.ItemOSMecan

interface ItemOSMecanRepository {

    suspend fun addAllItemOSMecan(itemOSMecanList: List<ItemOSMecan>)

    suspend fun deleteAllItemOSMecan()

    suspend fun getAllItemOSMecan(): List<ItemOSMecan>

}