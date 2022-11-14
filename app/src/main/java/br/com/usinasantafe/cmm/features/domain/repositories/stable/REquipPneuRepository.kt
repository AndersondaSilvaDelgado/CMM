package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.REquipAtiv
import br.com.usinasantafe.cmm.features.domain.entities.REquipPneu
import kotlinx.coroutines.flow.Flow

interface REquipPneuRepository {

    suspend fun addAllREquipPneu(rEquipPneuList: List<REquipPneu>)

    suspend fun deleteAllREquipPneu()

    suspend fun getREquipPneu(nroEquip: String): Flow<Result<List<REquipPneu>>>

}