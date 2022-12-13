package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.REquipPneu
import kotlinx.coroutines.flow.Flow

interface REquipPneuRepository {

    suspend fun addAllREquipPneu(rEquipPneuList: List<REquipPneu>)

    suspend fun deleteAllREquipPneu()

    suspend fun recoverREquipPneu(nroEquip: String): Flow<Result<List<REquipPneu>>>

}