package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.EquipSeg
import kotlinx.coroutines.flow.Flow

interface EquipSegRepository {

    suspend fun addAllEquipSeg(equipSegList: List<EquipSeg>)

    suspend fun deleteAllEquipSeg()

    suspend fun recoverAllEquipSeg(): Flow<Result<List<EquipSeg>>>

}