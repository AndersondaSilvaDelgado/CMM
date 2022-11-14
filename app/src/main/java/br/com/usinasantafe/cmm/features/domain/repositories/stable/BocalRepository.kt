package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Bocal
import kotlinx.coroutines.flow.Flow

interface BocalRepository {

    suspend fun addAllBocal(bocalList: List<Bocal>)

    suspend fun deleteAllBocal()

    suspend fun getAllBocal(): Flow<Result<List<Bocal>>>

}