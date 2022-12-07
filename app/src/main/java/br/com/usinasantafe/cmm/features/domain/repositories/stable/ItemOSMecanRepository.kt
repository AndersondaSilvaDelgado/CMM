package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.ItemOSMecan
import kotlinx.coroutines.flow.Flow

interface ItemOSMecanRepository {

    suspend fun addAllItemOSMecan(itemOSMecanList: List<ItemOSMecan>)

    suspend fun deleteAllItemOSMecan()

    suspend fun recoverAllItemOSMecan(): Flow<Result<List<ItemOSMecan>>>

}