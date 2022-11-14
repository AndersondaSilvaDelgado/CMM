package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Equip
import kotlinx.coroutines.flow.Flow

interface EquipRepository {

    suspend fun addAllEquip(equipList: List<Equip>)

    suspend fun deleteAllEquip()

    suspend fun getEquip(nroEquip: String): Flow<Result<List<Equip>>>

}