package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.REquipAtiv
import kotlinx.coroutines.flow.Flow

interface REquipAtivRepository {

    suspend fun addAllREquipAtiv(rEquipAtivList: List<REquipAtiv>)

    suspend fun deleteAllREquipAtiv()

    suspend fun getREquipAtiv(nroequip: String): Flow<Result<List<REquipAtiv>>>

}