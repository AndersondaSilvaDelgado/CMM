package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import kotlinx.coroutines.flow.Flow

interface EquipRepository {

    suspend fun addAllEquip(equipList: List<Equip>)

    suspend fun deleteAllEquip()

    suspend fun getEquip(): Equip

    suspend fun hasEquip(): Boolean

    suspend fun updateHorimetroEquip(horimetro: Double): Boolean

    suspend fun recoverEquip(nroEquip: String): Flow<Result<List<Equip>>>

}