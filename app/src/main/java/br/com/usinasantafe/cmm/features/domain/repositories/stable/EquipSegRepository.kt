package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.EquipSeg
import kotlinx.coroutines.flow.Flow

interface EquipSegRepository {

    suspend fun addAllEquipSeg(equipSegList: List<EquipSeg>)

    suspend fun checkEquipSeg(nroEquip: Long, typeEquigSeg: Long): Boolean

    suspend fun deleteAllEquipSeg()

    suspend fun recoverAllEquipSeg(): Flow<Result<List<EquipSeg>>>

}