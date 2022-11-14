package br.com.usinasantafe.cmm.features.domain.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Pneu
import kotlinx.coroutines.flow.Flow

interface PneuRepository {

    suspend fun addAllPneu(pneuList: List<Pneu>)

    suspend fun deleteAllPneu()

    suspend fun getAllPneu(): Flow<Result<List<Pneu>>>
}