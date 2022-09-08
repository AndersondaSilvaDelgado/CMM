package br.com.usinasantafe.cmm.features.core.domain.repositories

import br.com.usinasantafe.cmm.features.core.domain.entities.REquipAtiv

interface REquipAtivRepository {

    suspend fun addAllREquipAtiv(rEquipAtivList: List<REquipAtiv>)

    suspend fun deleteAllREquipAtiv()

    suspend fun getAllREquipAtiv(): List<REquipAtiv>

}