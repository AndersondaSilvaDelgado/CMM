package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.Equip

interface EquipRepository {

    suspend fun addEquip(equip: Equip)

    suspend fun deleteAllEquip()

    suspend fun getEquip(nroEquip: Long): Equip

}