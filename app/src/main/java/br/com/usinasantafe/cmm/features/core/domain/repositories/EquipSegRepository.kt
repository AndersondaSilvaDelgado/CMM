package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.EquipSeg

interface EquipSegRepository {

    suspend fun addAllEquipSeg(equipSegList: List<EquipSeg>)

    suspend fun deleteAllEquipSeg()

    suspend fun getAllEquipSeg(): List<EquipSeg>

}